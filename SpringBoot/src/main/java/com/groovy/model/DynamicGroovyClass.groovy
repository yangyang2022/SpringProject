package com.groovy.model

/**
 * Created by syy on 2017/3/17.
 */
class DynamicGroovyClass {

    def methodMissing(String name,args){
        println("you called $name with ${args.join(' ,')}")
        args.size()
    }

    static def sumOfBlock(int n,block){
        def list = []
        1.upto(n){
            if(block(it)) list << it
        }
        list
    }

    static void main(String... args) {
        println sumOfBlock(10,{it**2})
    }
}
