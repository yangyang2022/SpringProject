package com.yangyang.task;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TaskB implements TaskDemo{
    //@Scheduled(cron = "0/1 * * * *  ?")
    //@Scheduled(fixedRate = 2000)
    @Override
    public void specialTask() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()) + " b task ... ");
    }
}