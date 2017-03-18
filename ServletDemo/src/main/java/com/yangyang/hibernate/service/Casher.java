package com.yangyang.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Casher implements ICasher {

    @Autowired
    private IBookService bookService;

    @Override
    public void check(String username, List<String> isbns) {
        for(String isbn:isbns){
            bookService.purches(username,isbn);
        }
    }
}
