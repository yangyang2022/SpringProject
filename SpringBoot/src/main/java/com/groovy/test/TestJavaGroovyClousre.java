package com.groovy.test;

import com.groovy.model.AGroovyClass;
import com.groovy.model.DynamicGroovyClass;
import groovy.lang.GroovyObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

interface testInter{
    void test();
}
public class TestJavaGroovyClousre {
    public static void main1(String[] args) {
        AGroovyClass aGroovyClass = new AGroovyClass();
        Object res = aGroovyClass.useClosure(new Object() {
            //java called the call method from closure
            public String call() {
                return "you called from groovy !";
            }
        });
        System.out.println("res: "+res);
        System.out.println("res2: "+aGroovyClass.passToClosure(2,new Object(){
            public String call(int value){
                return "call from groovy with value: "+value;
            }
        }));

    }

    public static void main2(String[] args) {
        GroovyObject instance = new DynamicGroovyClass();
        Object o1 = instance.invokeMethod("squeak", new Object[]{});
        System.out.println("result: "+o1);
        Object o2 = instance.invokeMethod("squeak", new Object[]{"like", "a", "duck"});
        System.out.println("result: "+o2);

    }

    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        String path = "C:\\code\\groovy\\groovyTest.groovy";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        engine.put("name",20);
        int nname = (Integer) engine.get("name");
        System.out.println("nname is: "+nname);

        engine.eval(new FileReader(path));

        //GroovyScriptEngine engine1 = new GroovyScriptEngine();
    }
}
