package com.yangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller@RequestMapping("/session")
@SessionAttributes(value = {"book","desc"},types = Double.class)
public class SessionAttribute {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("book","金刚经");
        model.addAttribute("desc","般若系列重要经典书籍");
        model.addAttribute("price",999.99);
        return "redirect:get";
    }

    @GetMapping("/get")
    public String getSessionAttr(@ModelAttribute("book") String book, ModelMap model, SessionStatus sessionStatus){
        System.out.println("get Session .... ");
        System.out.println("get by@ModelAttribute: "+book);
        System.out.println("getby model: "+model.get("book")
                +" : "+model.get("desc")+" price: "+model.get("price"));
        sessionStatus.setComplete();//invalide
        return "redirect:complete";
    }

    @GetMapping("/complete")
    public String afterComplete(ModelMap model){
        System.out.println("after ... ");
        System.out.println("getby model: "+model.get("book")
                +" : "+model.get("desc")+" price: "+model.get("price"));
        return "redirect:/success";
    }


}
