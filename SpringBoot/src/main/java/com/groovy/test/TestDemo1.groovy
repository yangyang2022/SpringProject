package com.groovy.test

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.Immutable
import groovy.transform.InheritConstructors
import groovy.transform.ToString

import java.time.LocalDate

@ToString
class Complex{
    def real,imaginary
    def plus(other){
        new Complex(real: real-other.real ,imaginary: imaginary-other.imaginary)
    }
}
enum MethodLogics{
    EVO(5),
    XP(21),
    Scrum(30)
    ;
    final int daysInIteration

    MethodLogics(int daysInIteration) {
        this.daysInIteration = daysInIteration
    }
    def details(){
        println "${this} recommends $daysInIteration days for iteration"
    }
}

@ToString@Canonical(excludes = "firstname,age")
class Person{
    String firstname
    String lastname
    int age

}
class Worker{
    def work(){println('get work done')}
    def analyze(){println('worker analyze ...')}
    def writeReport(){println('get report writtern ... ')}
}
class Expert{
    def analyze(){println('expert analyze ...')}
}
class Manager{
    @Delegate Worker worker = new Worker()
    @Delegate Expert expert = new Expert()
}

class Heavy{
    def size  =10
    Heavy(){println "create havey with size: $size"}
}
class AsNeed{
    def value
    @Lazy Heavy heavy1 = new Heavy()
    @Lazy Heavy heavy2 = {new Heavy(size: value)}()
    AsNeed(){println("create Asneed ... ")}
}
@Singleton(lazy = true)
class TheUnique{
//    private TheUnique(){println('create theunique ... ')}
    static def hello(){print("hello")}
}

class A{
    @Override
    boolean equals(Object obj) {
        print('equals called')
        false
    }
}
class B implements Comparable{
    @Override
    boolean equals(Object obj) {
        print('b equal called ...')
        false
    }

    @Override
    int compareTo(Object o) {
        print('comparable called ... ')
        return 0
    }
}
@InheritConstructors
class myException extends RuntimeException{

}

class Calibrator{
    Calibrator(block){
        println('using ... ')
        block()
    }
}
class Semi{
    def val = 3;
    {
        println('hello')
    }
}
class Man{
    def helpMoving(){
        println("man moving ... ")
    }
}
class Cat{
    def helpMoving(){
        println("cat moving ... ")
    }
    def eatSuguarcane(){
        println('i love eat ... ')
    }
}
class Equipment{
    def calculator

    Equipment(calculator) {
        this.calculator = calculator
    }
    def simulate(){
        println('running simulate ... ')
        calculator()
    }
}
class Resource{
    def open(){println('open ... ')}
    def close(){println('close ... ')}
    def read(){println('read ... ')}
    def write(){println('write ... ')}
}

class Handler{
    def f1(){println("hander f1() ... ")}
    def f2(){println("hander f2() ... ")}
}
class Example{
    def f1(){println("Example f1() ... ")}
    def f2(){println("Example f2() ... ")}

    def foo(block){
        block.delegate = new Handler()
        block()
    }
}

@Immutable
class RevenueDetails{
    int revenue
    ArrayList splits
}
class TestDemo1 {

//    def static task(name,String[] details){
//        println("$name--$details")
//    }
    def testException(){
        throw new myException("this is my exception")
    }

    def takeHelper(helper){
        helper.helpMoving()
        if(helper.metaClass.respondsTo(helper,'eatSuguarcane')){
            helper.eatSuguarcane()
        }
    }

//    @TypeChecked
    @CompileStatic
    def shout(String str){
        println('print touppercase ... ')
        println(str.toUpperCase())
//        println('print toiuppercase ... ')
//        println(str.toUppercase())
//        println(str.shout())
    }

    def catchLength(Object str){
//        println(str.reverse())
//        println(str.previous())
        if(str instanceof String){
            println(str.length())
        }else {
            println(str)
        }
    }

    static def pickEven(n,block){
        for (int i =2;i<=n;i+=2){
            block(i)
        }
    }
    static def totalSelectValues(n,clousure){
        def total = 0
        for(i in 1..n){
            if(clousure(i)) total+=i
        }
        total
    }

    static def tellFortune(block){
        block LocalDate.now(),"Your day is full with ceremony!"
    }

    static def tellFortunes(block){
        def postFuture = block.curry(LocalDate.now())
        postFuture 'Test1'
        postFuture 'Test2'
    }
    static doSomething(block){
        if(block){
            block()
        }else {
            println("defalut block ... ")
        }
    }

    static def use(block){
        def r = new Resource()
        try{
            r.open()
            block()
        }finally {
            r.close()
        }
    }
    static iterate(n,clousure){
        1.upto(n){
            println("in iterate with value ${it}")
            clousure(it)
        }
    }

    static completeOrder(amount,taxComputer){
        def tax = 0
        if(taxComputer.maximumNumberOfParameters == 2){
            tax = taxComputer(amount,6.05)
        }else {
            tax = taxComputer(amount)
        }
        println("Sales tax is $tax")
    }

    static checkType(block){
        println("numbers of parameters: ${block.maximumNumberOfParameters}")
        for(p in block.parameterTypes){println(p.name)}
        println('-----------')
    }
    static examClosure(block){
        block()
    }
    static f11(){println("main f1() ... ")}

    static timeIt(length,block){
        long  start = System.nanoTime()
        println "Max revenue for $length is ${block(length)}"
        long end = System.nanoTime()
        println("Time taken ${(end-start)/1.0e9} seconds")
    }
    static rodPrices(price,length){
        if(length == 0) new RevenueDetails(0,[])
        else {
            def maxReven = new RevenueDetails(Integer.MIN_VALUE,[])
            for(rodSize in 1..length){
                def revenHalf = rodPrices(price,length-rodSize)
                def potentialReven = new RevenueDetails(price[rodSize]+revenHalf.revenue,revenHalf.splits+rodSize)
                if(potentialReven.revenue > maxReven.revenue)
                    maxReven = potentialReven
            }
            maxReven
        }
    }
    static void main(String... args) {

//        timeIt(10,{10000.times {println("hi")}})

        def rodPrice = [0,1,3,4,5,8,9,11,12,14,
                        15,25,16,18,19,15,20,21,22,24,
                        25,24,26,28,29,35,37,38,39,40]
        def desiredLength = 27

        def cutRod
        cutRod = {
            price,length->
                if(length == 0) new RevenueDetails(0,[])
                else {
                    def maxReven = new RevenueDetails(Integer.MIN_VALUE,[])
                    for(rodSize in 1..length){
                        def revenHalf = rodPrices(price,length-rodSize)
                        def potentialReven = new RevenueDetails(price[rodSize]+revenHalf.revenue,revenHalf.splits+rodSize)
                        if(potentialReven.revenue > maxReven.revenue)
                            maxReven = potentialReven
                    }
                    maxReven
                }
        }.memoize()

//        timeIt(desiredLength,{length -> rodPrices(rodPrice,length)})
        timeIt(desiredLength,{length->cutRod(rodPrice,length)})

//        new Example().foo{
//            f1()
//            f2()
//        }
//        examClosure(){
//            println('In frist closure ... ')
//            println("class is "+getClass().name)
//            println("this is "+this+" ,super: "+this.getClass().superclass.name)
//            println("ower is: "+owner+" ,super: "+owner.class.superclass.name)
//            println("delegate is: "+delegate+" ,super is: "+delegate.class.superclass.name)
//
//            println("------------------------------------")
//            examClosure(){
//                println('In frist with closure ... ')
//                println("class is "+getClass().name)
//                println("this is "+this+" ,super: "+this.getClass().superclass.name)
//                println("ower is: "+owner+" ,super: "+owner.class.superclass.name)
//                println("delegate is: "+delegate+" ,super is: "+delegate.class.superclass.name)
//            }
//        }

//        checkType(){}
//        checkType(){it}
//        checkType(){->}
//        checkType(){val->}
//        checkType(){Date val -> }
//        checkType(){Date val,String s ->}

//        completeOrder(100){it*0.0825}
//        completeOrder(100){amount,rate->amount*(rate/100)}

//        doSomething{println("hello")}
//        doSomething()

//        tellFortunes{
//            date,futune->println("Forturn for ${date} is ${futune}")
//        }
//        println("calling itearte ... ")
//        def total = 0
//        iterate(4){
//            total += it
//            println("in clousure total so far is ${total}")
//        }
//        println("Done!!!")

//        use{println("test write ... ")}


//        tellFortune(){
//            date,fortune -> println("Fortune for ${date} is '$fortune'")
//        }


//        def eq1 = new Equipment({println('calculator 1')})
//        eq1.simulate()

//        def sum = totalSelectValues(10){it%2==0}
//        println("sum is: $sum")
//

//        pickEven(10,{println(it)})
//        int total = 0
//        pickEven(10){total += it}
//        println("sum is $total")



//        println(2 ** 4)
//        new TestDemo1().catchLength("hello")
//        new TestDemo1().catchLength(4)

//        def str = 'hello'
//        str.metaClass.shout = {->toUpperCase()}
//        new TestDemo1().shout(str)

//        new TestDemo1().takeHelper(new Man())
//        new TestDemo1().takeHelper(new Cat())

//        int[] arr = [1,2,3,4] as int[]
//        println(arr.class.name)

//        new Semi()

//        def cal = new Calibrator({println('hello ...')})

//        new A() == new A()
//        new B() == new B()


//        try {
//            new TestDemo1().testException()
//        }catch (myException e){
//            println(e.getMessage())
//        }

//    TheUnique.instance.hello()
//    TheUnique.instance.hello()

//            def asneed = new AsNeed(value: 100)
//            println(asneed.heavy1.size)
//            println(asneed.heavy1.size)
//            println(asneed.heavy2.size)

//        def m = new Manager()
//        m.work()
//        m.analyze()

//        def p = new Person(firstname: 'shen',lastname: 'yangyang',age: 123)
//        print(p)

//        task("hello ","a","b","c")
//        def name1 = "hello"
//        def name2 = "worldB"
//        println("$name1 -- $name2")
//        (name1,name2) = [name2,name1]
//        println("$name1 -- $name2")

//        for (c in 'a'..'z') print(c)
//        def lst = ['hello']
//        lst << "world"
//        println(lst)

//        def c1 = new Complex(real: 1,imaginary: 2)
//        def c2 = new Complex(real: 4,imaginary: 1)
//        println(c1)
//        println(c2)
//        println(c1+c2)

//        for(m in MethodLogics.values()){
//            m.details()
//        }

        //not error ???
//        List<Integer> list = new ArrayList<>();
//        list.add(1)
//        list.add("hello")
//        list.add(3.14)
//        list.each {print("$it")}
    }
}
