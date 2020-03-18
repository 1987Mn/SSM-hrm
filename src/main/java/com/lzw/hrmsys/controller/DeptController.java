package com.lzw.hrmsys.controller;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Dept;
import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.model.PageModel;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.github.pagehelper.util.StringUtil.isEmpty;


@Controller
public class DeptController  {

    @Autowired
    DeptService deptService;

    @RequestMapping("/deptlist")
    public ModelAndView deptlist(String name, String remark,
                             String pageNum, String pageSize){
        QueryModel<Dept> queryModel = new QueryModel<>();
        Dept dept = new Dept();

//        封装参数
        dept.setName(isEmpty(name)?null:name);
        dept.setRemark(isEmpty(remark)?null:remark);

        queryModel.setObj(dept);

        queryModel.setPageNum(isEmpty(pageNum)?1:Integer.valueOf(pageNum));
        queryModel.setPageSize(isEmpty(pageSize)?3:Integer.valueOf(pageSize));

//        查询数据库
        PageInfo<Dept> pageModel = deptService.getModels(queryModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deptlist",pageModel.getList());
        modelAndView.addObject("pageModel",pageModel);
        modelAndView.addObject("queryDept",dept);
        modelAndView.setViewName("dept/deptlist");
        return modelAndView;
    }

    @RequestMapping("/deptedit/{id}")
    public ModelAndView viewUser(@PathVariable(name = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Dept one = deptService.getOne(id);
        modelAndView.addObject("dept",one);
        modelAndView.setViewName("dept/deptadd");
        return modelAndView;

    }

    @RequestMapping("/deptadd")
    public String deptadd(User user){
        return "dept/deptadd";
    }

    @RequestMapping("/deptsave")
    public String deptsave(Dept dept, HttpServletRequest request){
        if (dept.getId()==null){
            deptService.add(dept);
        }else{
            deptService.update(dept);
        }
        return "redirect:/deptlist";

    }

    @RequestMapping("/deptdelete")
    public String deptdelete(String[] ids){
        for (String id:ids) {
            if(!isEmpty(id)){
                deptService.delete(Integer.valueOf(id));
            }
        }
        return "redirect:/deptlist";
    }

}
