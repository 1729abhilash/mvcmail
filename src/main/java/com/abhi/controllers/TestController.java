package com.abhi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @ResponseBody
    @RequestMapping("/test")
    public String  sayHello(){
        return "hey its working..";
    }


    @RequestMapping("/test2")
    public String  test2(){
        return "hello-world";
    }

}
