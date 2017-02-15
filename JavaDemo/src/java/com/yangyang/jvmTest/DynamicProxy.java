package com.yangyang.jvmTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {


    interface ihello{
        void sayHello();
    }
    static class Hello implements ihello{
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }
    static class DynamicHello implements InvocationHandler{
        private Object obj;

        public Object bind(Object obj){
            this.obj = obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                    obj.getClass().getInterfaces(),this);
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome !!!");
            return method.invoke(obj,args);
        }
    }

    public static void main(String[] args) {

        ihello hello = (ihello) new DynamicHello().bind(new Hello());
        hello.sayHello();

    }
}
