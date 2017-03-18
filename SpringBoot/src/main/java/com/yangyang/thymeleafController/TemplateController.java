package com.yangyang.thymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller@RequestMapping("/templates")
public class TemplateController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","yangyang");
        return "hello";
    }

}
