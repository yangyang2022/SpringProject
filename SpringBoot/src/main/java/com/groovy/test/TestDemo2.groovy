package com.groovy.test

class People{
    def walk(){println('wlak ... ')}
    def walk(int miles){println("walking $miles miles ... ")}
    def walk(String where,int mile){println("walking  $mile and miles $where")}
}
class TestDemo2 {

    static printClassInfo(obj){

        println("class:${obj.class.name}")
        println("super class: ${obj.getClass().superclass.name}")

    }
    static words(a,b,c,d){
        println("$a -- $b -- $c -- $d")
    }
    static void main(String... args) {


//        create data.xml
//        def langs = ['C++':'Stroustrup','Java':'Gosling','Lisp':'McCarthy','Modila-2':'Wirth','Oberon-2':'Wirth','Pascal':'Wirth']
//        def content = ''
//        langs.each {key,value->
//            def temp = """
//                            <language name=\'${key}\'>
//                                <author>${value}</author>
//                            </language>
//                        """
//            content += temp
//        }
//        content = "<languages>"+content+ "</languages>"
//        println(content)


//        def path = "F:\\mavenproject\\SpringProject\\SpringBoot\\src\\main\\resources\\data.txt"
//        new File(path).withWriter {
//            file -> file.write("some data ... ")
//        }
//        def matcher = new File(path).text =~ /\d+/
//        def sum = 0
//        matcher.each {
//            sum += it.toInteger()
//        }
//        println("sum is ${sum}")

//        println(new File(path).text)
//        def list = []
//        new File(path).eachLine {
//            line ->
//        }

//        def person = new People()
//        person.invokeMethod('walk',null)
//        person.invokeMethod('walk',123)
//        person.invokeMethod('walk',"destination",123)

//        def list = [1,2,3,4]
//        list.with {
//            println("this $this")
//            println("ower: $owner")
//            println("delegate: $delegate")
//        }

//        def friends = [briang:'Brain Goetz',brians:'Brain Sletten',
//        davidb:'David Bock',davidg:'David Geary',
//        scotted:'Scott Davies',scottl:'Scott Leber',starth:'Statuth']
//
//        def groupByname = friends.groupBy {it.value.split(' ')[0]}
//        println(groupByname)
//        println groupByname.each {
//            firstname,buddies ->
//                println("$firstname : ${buddies.collect {key,fullname->fullname}.join(" ,")}")
//        }

//        def langs = ['c++':'Stroustrup','Java':'Gosling','Lisp':'McCarthy']
//        println(langs.getClass().name)
//        println(langs.Java)
//        println(langs.'c++')
//        langs.each {key,value->
//            println("key is: $key and value is $value")
//        }
//        println(langs.collect {language,author->
//            language.replaceAll(/\+/,'p')
//        })

//        def list = [1,2,3,4,[11,22],[[1,2,3],[5,6]]]
//        println(list.flatten())

//        words(*list)

//        printClassInfo("hello")
        
//        def what = new StringBuilder('fence')
//        def text = "The cow jumped over the ${what}"
//        println(text)
//        what.replace(0,5,"Moon")
//        println(text)

//        def price = 684.71
//        def company = 'Google'
//        def quote = "Today ${->company} stock closed at ${->price}"
//        println(quote)
//
//        def stocks = [Apple:663.01,Microsoft:30.95]
//        stocks.each {key,value->
//            company = key
//            price = value
//            println(quote)
//        }

//        def langs = ['c++':'Stroustrup','Java':'Gosling','Lisp':'McCarthy']
//        def content = ''
//        langs.each {language,author->
//            def fragment = """
//                <language name="${language}">
//                    <author>${author}</author>
//                </language>
//            """
//            content += fragment
//        }
//        def xml = "<languages>${content}</languages>"
//        println xml

//        def str = '姚明明天起床'
//        println(str)
//        def res = (str =~ /姚明/).replaceAll("hip")
//        println(res)

//        def lst = [1,3,4,1,8,9,2,6]

//        lst.each {print(it+" ,")}
//        println()
//        lst.reverseEach {print(it+" ,")}
//
//        def doubled = []
//        lst.each {doubled << it*2}
//        println(doubled)

//        println(lst.collect {it*2})
//
//        println(lst.findIndexOf{it == 9})
//        println(lst.findAll {it > 4})
//        println(lst.sum())



    }
}
