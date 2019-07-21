package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {
    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("name", "wistbean");
        return "hello";
    }

    @RequestMapping("/hi")
    public String sayHi(Model model){
        model.addAttribute("name", "wistbean");
        return "hi";
    }
}
