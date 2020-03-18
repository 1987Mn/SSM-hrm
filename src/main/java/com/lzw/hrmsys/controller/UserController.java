package com.lzw.hrmsys.controller;

import com.github.pagehelper.PageInfo;
import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.model.QueryModel;
import com.lzw.hrmsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.github.pagehelper.util.StringUtil.isEmpty;


/**
 * @author STUDY
 */
@Controller
public class UserController extends HttpServlet {

    @Autowired
    UserService userService;

    @RequestMapping("/userlist")
    public ModelAndView userlist(String username,String loginname,String status,
                             String pageNum,String pageSize){
        QueryModel<User> queryModel = new QueryModel<>();
        User user = new User();

//        封装参数
        user.setUsername(isEmpty(username)?null:username);
        user.setLoginname(isEmpty(loginname)?null:loginname);
        user.setStatus(isEmpty(status)?null:Integer.valueOf(status));

        queryModel.setObj(user);

        queryModel.setPageNum(isEmpty(pageNum)?1:Integer.valueOf(pageNum));
        queryModel.setPageSize(isEmpty(pageSize)?3:Integer.valueOf(pageSize));

//        查询数据库
        PageInfo pageInfo = userService.getModels(queryModel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",pageInfo.getList());
        modelAndView.addObject("pageModel",pageInfo);
        modelAndView.addObject("queryUser",user);
        modelAndView.setViewName("user/userlist");

        return modelAndView;
    }

    @RequestMapping("/viewUser/{id}")
    public ModelAndView viewUser(@PathVariable(name = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        User one = userService.getOne(id);
        modelAndView.addObject("user",one);
        modelAndView.setViewName("user/useradd");
        return modelAndView;

    }

    @RequestMapping("/useradd")
    public String useradd(User user){
        return "user/useradd";
    }

    @RequestMapping("/usersave")
    public String usersave(User user, HttpServletRequest request){
            if (user.getId()==null){
                user.setCreatedate(new Date());
                userService.add(user);
            }else{
                userService.update(user);
            }
            return "redirect:/userlist";

    }

    @RequestMapping("/userdelete")
    public String userdelete(String[] userIds){
        for (String id:userIds) {
            if(!isEmpty(id)){
                userService.delete(Integer.valueOf(id));
            }
        }
        return "redirect:/userlist";
    }

}
