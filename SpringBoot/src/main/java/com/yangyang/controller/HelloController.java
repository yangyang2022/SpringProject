package com.yangyang.controller;


import com.yangyang.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloController {
    @RequestMapping("/test")
    public String testHello(){
        throw new RuntimeException("this is a runtime exception");
        //return "hello test";
    }

    @RequestMapping("/testuser")@ResponseBody
    public User testUser(){return new User("shen","yangyang", LocalDate.now().minusYears(20));};

}
