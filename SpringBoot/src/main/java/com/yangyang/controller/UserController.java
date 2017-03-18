package com.yangyang.controller;

import com.yangyang.dao.UserRepo;
import com.yangyang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/{lastname}")
    User findUserByLastame(@PathVariable("lastname") String lastname){
        System.out.println("name is: "+lastname);
        return userRepo.findByName(lastname);
    }


    @GetMapping("/users")
    List<User> findAllUser(){
        return userRepo.findAll();
    }
}
