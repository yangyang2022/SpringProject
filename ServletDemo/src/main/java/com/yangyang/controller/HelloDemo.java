package com.yangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Controller
public class HelloDemo {

    @GetMapping(value = "/hello/{id}")
    public String helloWorld(@PathVariable(value = "id")int id,
    @RequestHeader Optional<String> country
    ){
        country.ifPresent(value -> System.out.println("optional country: "+value));
        System.out.println(id+ " - "+country);
        return "hello";
    }
}
