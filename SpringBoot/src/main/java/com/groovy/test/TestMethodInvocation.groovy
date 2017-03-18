package com.groovy.test

class AnIntercepteable{
    def existingMethod(){println('existed ... ')}
    def invokeMethod(String name,args){'intercepted'}
}
class AGroovyObject2{
    def existed(){'existedMethod'}
    def existed2(){'existedMethod2'}
    def closureProp = {->'closure Prop'}
}
class ClassWithInvokeAndMissingMethod{
    def existed(){'existed'}
    def invokemethod(String name,args){'invoke called'}
    def methodMissing(String name,args){'missing called'}
}
class ClassWithInvokeOnly{
    def existedMethod(){'existedMethod'}
    def invokeMethod(String name,args){'invoke called'}
}

class TestMethodInvocation extends GroovyTestCase {

    void testCall(){
        def val = new Integer(3)
        Integer.getMetaClass().toString = {->'intercepted ... '}
        println(val.toString())
    }
    void testIntercepedableCalled(){
        println('------------------- begin -----------------')
        AGroovyObject2.metaClass.existed2 = {->'Intercepted ... '}
        def obj = new AGroovyObject2()
        println obj.existed2()
        println obj.existed()
        println obj.closureProp()
        println('------------------- end -----------------')
    }

    void testMethod(){
        def str = 'hello'
        def methodName = 'toUpperCase'
        def methodIfInterest = str.metaClass.getMetaMethod(methodName)
        println(methodIfInterest.invoke(str))

        println String.metaClass.respondsTo(str,'toUpperCase','Test')?'yes':'no'
    }

    def printInfo(obj){
        def usrProperty = 'bytes'
        def usrMethod = 'toUpperCase'
        println(obj[usrProperty])
        println(obj."$usrProperty")
        println(obj."$usrMethod"())
        println(obj.invokeMethod(usrMethod,null))
    }
    void testProperties(){
//        'hello'.properties.each {println(it)}
        printInfo('hello')
    }

}
