package com.lzw.hrmsys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class HrmLogoutController  {

	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("window.open ('/loginPage','_top')");
			out.println("</script>");
			out.println("</html>");
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
