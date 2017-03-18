package com.yangyang.concert;

import org.springframework.stereotype.Component;

@Component
public class Calcu implements ICalcu {
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int div(int i, int j) {
        if(j != 0)
            return i/j;
        throw new RuntimeException("除数不能为0!!!");
    }
}
