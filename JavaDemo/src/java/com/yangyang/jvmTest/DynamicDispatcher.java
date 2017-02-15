package com.yangyang.jvmTest;

public class DynamicDispatcher {

    static abstract class Human{
        protected abstract void sayHello();
    }
    static class Man extends Human{
        @Override
        protected void sayHello() {
            System.out.println("hello man");
        }
    }
    static class Woman extends Human{
        @Override
        protected void sayHello() {
            System.out.println("hello woman !!!");
        }
    }

    public int calc(){
        int a = 100;
        int b = 200;
        int c = 300;
        return (a+b)*c;
    }
    public static void main(String[] args) {
        //Human man = new Man();
        //Human woman = new Woman();
        //man.sayHello();
        //woman.sayHello();
        //man = new Woman();
        //man.sayHello();

        System.out.println(new DynamicDispatcher().calc());

    }
}
