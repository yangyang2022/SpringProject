package com.yangyang.Java8;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class LambdaTest01 {
    private static String filePath = "C:\\code\\";
    private static Path path = new File(filePath+"temp.txt").toPath();

    @Test
    public void testDemo() {

        print(()->"xijingping",name->"Mr: "+name);

        doSomething(name-> System.out.println(name));

        System.out.println(LambdaTest01.class.getDeclaredMethods().length);

        Arrays.asList(LambdaTest01.class.getDeclaredMethods())
                .forEach(e-> System.out.println(e.getName()));
    }

    private static void print(Supplier<String> nameSuplier, Function<String,String> decorator){
        System.out.println("hello "+decorator.apply(nameSuplier.get()));
    }
    private static void doSomething(Consumer<String> consumer){consumer.accept("yangyang");}
    private interface NameSupplier{
        String get();
    }

    @Test
    public void testLambda01() {

        MyInterFace consumer = s -> System.out.println(s);
        consumer.print("yangyang");
        consumer.awesomePrint("yangyang");

        MyInterFace.foo("yangyang");
    }
    @FunctionalInterface
    private interface MyInterFace{

        void print(String val);

        static void foo(String s){
            System.out.println(s);
        }

        default void awesomePrint(String s){
            print("***"+s);
            foo("***"+s);
        }
    }

    @Test
    public void testServiable() throws IOException, ClassNotFoundException {

        //Serializable lambda function
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))){
            out.writeObject((Runnable & Serializable)()-> System.out.println("hello runnable!!!"));
        }

        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))){
            Runnable r = (Runnable) in.readObject();
            r.run();
        }
    }

    @Test
    public void testStream() {
        List<String> persons = Arrays.asList("yangyang", "yaojun", "xiaomo", "lili");
        int sum = persons.stream().filter(name -> name.contains("y")).mapToInt(String::length).sum();

        assertEquals(14,sum);

        List<Integer> list = getNameContainsI(persons)
                .collect(Collectors.toList());

        assertThat(list).contains(4,6);
        assertThat(list).hasSize(3);

    }

    public Stream<Integer> getNameContainsI(List<String> persons) {
        return persons.stream()
                .filter(name -> name.contains("i"))
                .map(String::length);
    }

    @Test
    public void testArrayList() {
        List<List<String>> list = Arrays.asList(Arrays.asList("one", "two"), Arrays.asList("1", "2"));
        list.forEach(System.out::println);
    }

    interface Seclector{
        boolean pick(int value);
    }
    static class EvenSelector implements Seclector{
        @Override
        public boolean pick(int value) {
            return value % 2 == 0;
        }
    }
    private static void totalValue(List<Integer> list,Seclector seclector){
        int res = 0;
        for(Integer e:list){
            if(seclector.pick(e)) res+=e;
        }
        System.out.println("result: "+res);
        return;
    }
    @Test
    public void testEvenSelector() {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        totalValue(values,e->e%2==0);

    }
}
