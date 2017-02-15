package com.yangyang.Java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8Test {

    //static List<Persons> createPerson = Arrays.asList(
    //        new Person("Sara",20,Gender.FEMALE),
    //        new Person("Sara",22,Gender.FEMALE),
    //        new Person("Bob",20,Gender.MALE),
    //        new Person("Paula",32,Gender.FEMALE),
    //        new Person("Paul",32,Gender.MALE),
    //        new Person("Jack",2,Gender.MALE),
    //        new Person("Jack",72,Gender.MALE),
    //        new Person("Jill",12,Gender.FEMALE)
    //
    //);
    private static void printPersons(List<Persons> persons){
        persons.forEach(System.out::println);
    }

    private static void printEven(int number, Predicate<Integer> predicate,String message){
        System.out.println(number + " " + message + predicate.test(number));
    }
    private static Predicate<Integer> isGreater(int num){
        return e -> e > num;
    }
    public static void main(String[] args) {

        Consumer<Persons> print = System.out::println;

        //List<Persons> persons = createPerson;

        //sort by age and then sort by age
        //persons.stream()
        //        .sorted(comparing(Person::getAge)
        //                .thenComparing(Person::getName))
        //        .forEach(print);

        //grouping
        //Map<Integer, List<String>> listMap = persons.stream()
        //        .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
        //System.out.println(listMap);


        Predicate<Integer> isEven = e -> e % 2 == 0;
        Predicate<Integer> isGT5 = e -> e > 5;

        Function<Integer,Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

        printEven(33,isGreaterThan.apply(30),"");
        printEven(33,isGreaterThan.apply(40),"");

        //printEven(6,isEven,"is Even? ");
        //
        //printEven(1,isGreater(5),"is Greater 5 ");
        //
        //printEven(4,isGT5.and(isEven)," e > 5 && isEven ? ");
        //printEven(4,isGT5.or(isEven)," e > 5 || isEven ? ");
    }
}
