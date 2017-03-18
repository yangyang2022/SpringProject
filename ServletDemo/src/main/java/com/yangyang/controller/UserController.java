package com.yangyang.controller;

import com.yangyang.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;


@Controller@RequestMapping("/user")
public class UserController {

    //@Autowired
    //private UserValidate userValidate;

    //@InitBinder
    //private void dataBind(WebDataBinder binder){
    //    System.out.println("init binder ... ");
    //    binder.addValidators(userValidate);
    //}
    //@ModelAttribute("classname")
    //public String setModel(){
    //    System.out.println("setModel1....");
    //    return this.getClass().getName();
    //}
    //@ModelAttribute
    //public void setModel2(Model model){
    //    System.out.println("setModel2....");
    //    model.addAttribute("name","excilent");
    //}
    //@ModelAttribute
    //public String setModel3(){
    //    System.out.println("setModel3....");
    //    return "hello yangyang";
    //}

    @GetMapping("/input")
    public String input(Model model){
        model.addAttribute(new User());
        return "userInput";
    }
    @PostMapping("/signIn")
    public String sign(@ModelAttribute("user")@Valid User user, BindingResult br, RedirectAttributes ra, Model model){
        if(br.hasErrors()){
            model.addAttribute(user);
            System.out.println(br.getModel());
            return "userInput";
        }
        ra.addFlashAttribute("user",user);
        return "redirect:/suc";
    }
    @GetMapping("/test")
    public String index(Model model){
        Map<String, Object> asMap = model.asMap();
        System.out.println("classname: "+asMap.get("classname"));
        System.out.println("name: "+asMap.get("name"));
        System.out.println("string: "+asMap.get("string"));
        return "success";
    }

    @GetMapping("/user")
    @ResponseBody public String getUser(){
        return "hello world";
    }
}
