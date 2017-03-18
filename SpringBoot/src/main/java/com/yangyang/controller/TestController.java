package com.yangyang.controller;

import com.yangyang.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/users")
    public List<User> getUsers(){
        return Arrays.asList(
                new User("shen","yangyang1", LocalDate.now().minusYears(20)),
                new User("shen","yangyang2", LocalDate.now().minusYears(10)),
                new User("shen","yangyang3", LocalDate.now().minusYears(2)),
                new User("shen","yangyang4", LocalDate.now().minusYears(1))
        ) ;
    }
}
