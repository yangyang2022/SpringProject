package com.yangyang.concert;

import org.springframework.stereotype.Component;

/**
 * Created by syy on 2017/2/23.
 */

@Component
public class Performance implements IPerformance {
    @Override
    public void perform() {
        System.out.println("performce ok ... ");
        //throw new RuntimeException("performance fail ... ");
    }

    @Override
    public void seat(String name) {
        System.out.println(name+" is seating ...");
    }
}
