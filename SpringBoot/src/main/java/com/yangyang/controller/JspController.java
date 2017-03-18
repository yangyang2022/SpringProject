package com.yangyang.controller;


import com.Application;
import com.yangyang.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class JspController {

    @Value("${application.hello}")
    private String hello;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @GetMapping("/jsp")
    public String testJsp(Model model){
        System.out.println("Info: "+hello);
        model.addAttribute("hello",hello);
        return "demo/testjsp";
    }

    @GetMapping("/jdbc")
    public String jdbcTest(){

        createtable();

        return "hello";
    }

    private void createtable(){
        log.info("======================= start ============================ ");
        log.info("create table ... ");
        jdbcTemplate.execute("DROP TABLE if EXISTS customers");
        jdbcTemplate.execute("CREATE TABLE customers (id serial ,firstname VARCHAR (50),lastname VARCHAR (50))");

        //splite names
        List<Object[]> spliteNames = Stream.of("shen yangyang","hello world","Tom jerry")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        jdbcTemplate.batchUpdate("INSERT INTO customers(firstname,lastname) VALUES (?,?)",spliteNames);

        String sql = "select id,firstname,lastname from customers where firstname=?";
        jdbcTemplate.query(sql,new Object[]{"shen"},
                (rs,rowNum)->new Customer(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"))
        ).forEach(e->log.info(e.toString()));
        log.info("========================== end ========================");
    }
}
