package com.groovy.model

/**
 * Created by syy on 2017/3/17.
 */
class AGroovyClass {
    def useClosure(block){
        println("calling closure ... ")
        block()
    }
    def passToClosure(int value,block){
        println("Simple pass $value to the give closure ... ")
        block(value)
    }
}
