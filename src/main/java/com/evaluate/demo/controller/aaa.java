package com.evaluate.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aaa {
    @RequestMapping("/")
    public String a(){
        return "login";
    }
}
