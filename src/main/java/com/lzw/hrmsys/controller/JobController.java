package com.lzw.hrmsys.controller;


import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Dept;
import com.lzw.hrmsys.domain.Job;
import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.model.PageModel;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static com.github.pagehelper.util.StringUtil.isEmpty;


@Controller
public class JobController extends HttpServlet {

    @Autowired
    JobService jobService;


    @RequestMapping("/joblist")
    public ModelAndView joblist(String name, String remark,
                             String pageNum, String pageSize) {
        QueryModel<Job> queryModel = new QueryModel<>();
        Job job = new Job();

//        封装参数
        job.setName(isEmpty(name)?null:name);
        job.setRemark(isEmpty(remark)?null:remark);

        queryModel.setObj(job);

        queryModel.setPageNum(isEmpty(pageNum)?1:Integer.valueOf(pageNum));
        queryModel.setPageSize(isEmpty(pageSize)?3:Integer.valueOf(pageSize));

//        查询数据库
        PageInfo<Job> pageModel = jobService.getModels(queryModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("joblist",pageModel.getList());
        modelAndView.addObject("pageModel",pageModel);
        modelAndView.addObject("queryjob",job);
        modelAndView.setViewName("job/joblist");
        return modelAndView;
    }


    @RequestMapping("/jobedit/{id}")
    public ModelAndView jobedit(@PathVariable(name = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Job one = jobService.getOne(id);
        modelAndView.addObject("job",one);
        modelAndView.setViewName("job/jobadd");
        return modelAndView;

    }

    @RequestMapping("/jobadd")
    public String jobadd(Job job){
        return "job/jobadd";
    }

    @RequestMapping("/jobsave")
    public String jobsave(Job job, HttpServletRequest request){
        if (job.getId()==null){
            jobService.add(job);
        }else{
            jobService.update(job);
        }
        return "redirect:/joblist";

    }

    @RequestMapping("/jobdelete")
    public String jobdelete(String[] ids){
        for (String id:ids) {
            if(!isEmpty(id)){
                jobService.delete(Integer.valueOf(id));
            }
        }
        return "redirect:/joblist";
    }




}
