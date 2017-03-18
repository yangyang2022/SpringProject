package com.yangyang.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component@Aspect
public class Audience {

    @Pointcut("execution(* com.yangyang.concert.IPerformance.seat())")
    public void doSeat(){}

    @Pointcut("execution(* com.yangyang.concert.*.*(..)))")
    public void performance(){}

    @Before("performance()")
    public void silentCellPhone(){
        System.out.println("silent cell phone ... ");
    }

    @Before("doSeat() && args(name)")
    public void takeseats(String name){
        System.out.println("Taking seats ..."+name);
    }

    @After("performance()")
    public void applause(){
        System.out.println("CLAP CALP CALP .... ");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

}
