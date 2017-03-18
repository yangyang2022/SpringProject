package com.yangyang.web;

import com.yangyang.dao.ISpittleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpittleController {

    @Autowired
    private ISpittleRepo spittleRepo;

    @GetMapping("/spittles")
    public String spittles(Model model){
        model.addAttribute("sps",spittleRepo.findSpittles(0,10));
        model.addAttribute("hello","world");
        System.out.println(spittleRepo.findSpittles(0, 10));
        return "spittles";
    }

    @GetMapping("/success")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
}
