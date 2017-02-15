package com.yangyang.Java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class EffectiveTest {

    private static boolean yesOrNo(String s){
        s = s.toLowerCase();
        if(s.equals("yes") || s.equals("y") || s.equals("t")){
            s = "true";
        }
        return Boolean.getBoolean(s);
    }
    
    @Test
    public void testDemo1() {

        //System.out.println(yesOrNo("true") + " : " + yesOrNo("Yes")); //false false
        System.out.println(Boolean.getBoolean("true")); //false
        System.out.println(Boolean.parseBoolean("true")); //true

    }

    @Test
    public void testDemo2() {
        String[] strs = {"4","0", "1", "2", "3", "4", "5"};
        List<Integer> ints = new ArrayList<>();
        for(String s:strs){
            ints.add(Integer.valueOf(s));
        }

        int index = Collections.binarySearch(ints,1,cmp);
        System.out.println("index: "+index);

    }
    private static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
        }
    };

    @Test
    public void testLongAdder() {

        LongAdder adder = new LongAdder();

        LongAccumulator la = new LongAccumulator((x,y)->x+y,10l);

        System.out.println(la.intValue());

        la.accumulate(123);

        System.out.println(la.getThenReset());
        System.out.println(la.get());

    }
}
