package com.lzw.hrmsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {

    @RequestMapping("/selectNotice")
    public String selectNotice(){

        return "/notice/notice";
    }


    @RequestMapping("/addNotice")
    public String addNotice(){

        return "/notice/notice";
    }
}
