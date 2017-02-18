package com.yangyang.task;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TaskA implements TaskDemo{
    ////@Scheduled(cron = "0/2 * * * * ? ")
    //@Scheduled(fixedRate = 4000)
    @Override
    public void specialTask() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()) + " a task ... ");
    }
}