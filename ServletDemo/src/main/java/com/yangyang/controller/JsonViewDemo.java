package com.yangyang.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Optional;

@RestController
public class JsonViewDemo {

    private static final String SUCCESS = "success";

    //@ControllerAdvice
    //private static class JsonAdvice extends AbstractJsonpResponseBodyAdvice{
    //    public JsonAdvice(){
    //        super("callback");
    //    }
    //}
    //@GetMapping("/user")//@ResponseBody
    //@JsonView(PublicView.class)
    //public User getUser(){
    //    System.out.println("hello world");
    //    return new User("yangyang","123123");
    //}

    @RequestMapping("/date")
    public String tsetDate(@RequestParam Optional<LocalDate> data){
        Log log = LogFactory.getLog(JsonViewDemo.class);

        StringBuilder sb = new StringBuilder("Date");
        data.ifPresent(date -> sb.append(data.toString()));
        System.out.println(sb.toString());
        return SUCCESS+"yangyang";
    }

    @RequestMapping("/status")
    public ResponseEntity<String> handler() throws URISyntaxException {
        URI location = new URI("http://localhost:8080/status");
        return ResponseEntity.created(location).body("hello world,this is just repsonceEntity .. ");
    }
    @RequestMapping("/ok")
    public ResponseEntity<String> fobidon(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>("this is 洋洋 ... ",headers, HttpStatus.OK);
    }
}
