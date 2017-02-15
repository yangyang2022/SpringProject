package com.yangyang.Java8;

import org.junit.Test;

import java.util.List;
import java.util.Set;

public class GenericDemo {

    private static <T> T anyObject(){return null;}

    @Test
    public void testDemo() {
        //foo((List<String>) anyObject()); //warnning
        foo(GenericDemo.<Set<String>>anyObject());
    }
    private void foo(List<String> list){
        System.out.println("list<String> ...");
    }
    private void foo(Set<String> set){
        System.out.println("Set<String> ... ");
    }
}
