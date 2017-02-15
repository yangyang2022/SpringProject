package com.yangyang.Java8;


import com.utils.SleepUtils;
import org.junit.Test;

class Heavy{
    public Heavy(){
        System.out.println("Heavy created ... ");
        SleepUtils.sleep4Second();
    }

    @Override
    public String toString() {
        return "quiet heavy ... ";
    }
}
class HeavyHolder{
    private Heavy heavy;
    public Heavy getHeavy(){
        if(heavy == null){
            heavy = new Heavy();
        }
        return heavy;
    }
}
class EvluateDemo{
    public static boolean evaluate(final int value){
        System.out.println("evaluate ... ");
        SleepUtils.sleep2Second();
        return value > 200;
    }
    public static boolean eagerEvaluator(boolean input1,boolean input2){
        System.out.println("eagerEvaluator called ... ");
        System.out.println("accept ? : "+(input1 && input2));
        return true;
    }
}
public class TestLazy {

    @Test
    public void testDemo1() {


    }
    
}
