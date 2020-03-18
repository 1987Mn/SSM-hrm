package com.lzw.hrmsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author STUDY
 *
 */
@SuppressWarnings("serial")
@Controller
public class HrmSysController extends HttpServlet {

	@RequestMapping("/main")
	public String main(){
		return "main";
	}

	@RequestMapping("/left")
	public String left(){
		return "left";
	}

	@RequestMapping("/right")
	public String right(){
		return "right";
	}

	@RequestMapping("/top")
	public String top(){
		return "top";
	}

}
