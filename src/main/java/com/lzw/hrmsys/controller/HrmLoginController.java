package com.lzw.hrmsys.controller;

import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HrmLoginController<a> extends HttpServlet {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/loginPage","/"})
    public ModelAndView loginPage(){
        return new ModelAndView("loginForm");
    }



    @RequestMapping("/login")
    public String login(HttpServletRequest request,String username,String password,Model model){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        }catch(UnknownAccountException uae){
            model.addAttribute("message_login", "未知账户");
            return "loginForm";
        }catch(IncorrectCredentialsException ice){
            model.addAttribute("message_login", "密码不正确");
            return "loginForm";
        }catch(LockedAccountException lae){
            model.addAttribute("message_login", "账户已锁定");
            return "loginForm";
        }catch(ExcessiveAttemptsException eae){
            model.addAttribute("message_login", "用户名或密码错误次数过多");
            return "loginForm";
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            // ae.printStackTrace();
            model.addAttribute("message_login", "用户名或密码不正确");
            return "loginForm";
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            return "redirect:/main";
        }else{
            token.clear();
        }
        model.addAttribute("message_login", "登陆失败");
        return "loginForm";
    }


}