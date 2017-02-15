package com.yangyang.jvmTest;

public class StaticDispatcher {

    static abstract class Human{}
    static class Man extends Human{}
    static class Women extends Human{}

    public void sayHello(Human human){
        System.out.println("hello guy !");
    }
    public void sayHello(Women human){
        System.out.println("hello women !");
    }
    public void sayHello(Man human){
        System.out.println("hello man !");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Women();

        StaticDispatcher sd = new StaticDispatcher();

        sd.sayHello(man);
        sd.sayHello(women);

        sd.sayHello((Man) man);
        sd.sayHello((Women) women);

    }
}
