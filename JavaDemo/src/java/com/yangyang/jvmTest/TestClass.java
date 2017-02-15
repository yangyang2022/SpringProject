package com.yangyang.jvmTest;

class Foo{

}
public class TestClass {
    private int m;
    void onlyMe(Foo foo){
        synchronized (foo){
            System.out.println("hello world");
        }
    }
    //public int inc(){
    //    int x ;
    //    try {
    //        x = 1;
    //        return x;
    //    } catch (Exception e) {
    //        x = 2;
    //        return x;
    //    } finally {
    //        x = 3;
    //    }
    //}

    public static void main(String[] args) {
        //List<String> list = Arrays.asList("hello","world","shen","yangyang");
        //list.forEach(System.out::println);


    }
}
