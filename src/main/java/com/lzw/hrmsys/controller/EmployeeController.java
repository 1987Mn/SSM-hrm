package com.lzw.hrmsys.controller;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.Employee;
import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.DeptService;
import com.lzw.hrmsys.service.EmployeeService;
import com.lzw.hrmsys.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.github.pagehelper.util.StringUtil.isEmpty;

@Controller
public class EmployeeController  {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    JobService jobService;
    @Autowired
    DeptService deptService;

    @RequestMapping("/employeelist")
    public ModelAndView employeelist(
            String job_id,String name,String cardId,String sex,String phone,
            String dept_id,String pageNum, String pageSize){
        QueryModel<Employee> queryModel = new QueryModel<>();
        Employee employee = new Employee();

//        封装参数
        employee.setJobId(isEmpty(job_id)?null:Integer.valueOf(job_id));
        employee.setName(isEmpty(name)?null:name);
        employee.setCardId(isEmpty(cardId)?null:cardId);
        employee.setSex(isEmpty(sex)?null:Integer.valueOf(sex));
        employee.setPhone(isEmpty(phone)?null:phone);
        employee.setDeptId(isEmpty(dept_id)?null:Integer.valueOf(dept_id));

        queryModel.setObj(employee);


        queryModel.setPageNum(isEmpty(pageNum)?1:Integer.valueOf(pageNum));
        queryModel.setPageSize(isEmpty(pageSize)?3:Integer.valueOf(pageSize));

//        查询数据库
        PageInfo<Employee> pageInfo = employeeService.getModels(queryModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employeelist",pageInfo.getList());
        modelAndView.addObject("deptList",deptService.getMore(null));
        modelAndView.addObject("jobList",jobService.getMore(null));
        modelAndView.addObject("pageModel",pageInfo);
        modelAndView.addObject("queryEmployee",employee);
        modelAndView.setViewName("employee/employeelist");
        return modelAndView;
    }

    @RequestMapping("/employeeedit/{id}")
    public String employeeedit(@PathVariable(name = "id") Integer id,Model model){
        Employee one = employeeService.getOneByObj(id);
        model.addAttribute("employee",one);
        return "forward:/employeeadd";
    }

    @RequestMapping("/employeeadd")
    public String employeeadd(Model model){
        model.addAttribute("depts",deptService.getMore(null));
        model.addAttribute("jobs",jobService.getMore(null));
        return "employee/employeeadd";
    }

    @RequestMapping("/employeesave")
    public String employeesave(Employee employee){
        if (employee.getId()==null){
            employeeService.add(employee);
        }else{
            employeeService.update(employee);
        }
        return "redirect:/employeelist";

    }

    @RequestMapping("/employeedelete")
    public String employeedelete(String[] userIds){
        for (String id:userIds) {
            if(!isEmpty(id)){
                employeeService.delete(Integer.valueOf(id));
            }
        }
        return "redirect:/employeelist";
    }


}