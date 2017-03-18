package com.groovy.test

import groovy.xml.StreamingMarkupBuilder

class TestXml {

    static void main(String... args) {

        def path = "F:\\mavenproject\\SpringProject\\SpringBoot\\src\\main\\resources\\data.xml"
//        def languages = new XmlParser().parse(path)
//        languages.each {
//            println("${it.'@name'} authored by ${it.author[0].text()}")
//        }
//        def languageByAuthor = {
//            authorname ->
//                languages.findAll {it.author[0].text() == authorname}.collect{it.'@name'}.join(" ,")
//        }
//        println("By Wirth: "+languageByAuthor("Wirth"))

//        def path1 = "F:\\mavenproject\\SpringProject\\SpringBoot\\src\\main\\resources\\data1.xml"

//        def xmls = new XmlSlurper().parse(path).declareNamespace(human:'Nautral')
        def langs = ['C++':'Stroustrup','Java':'Gosling','Lisp':'McCarthy','Modila-2':'Wirth','Oberon-2':'Wirth','Pascal':'Wirth']
        def xmlDoc = new StreamingMarkupBuilder().bind{
            mkp.xmlDeclaration()
            mkp.declareNamespace(computer:'Computer')
            languages{
                comment <<"Create using StremingMarkupBuilder "
                langs.each {key,value->
                    computer.language(name:key){
                        author(value)
                    }
                }
            }
        }
        new File(path).withWriter {
            file -> file << xmlDoc
        }
        println(xmlDoc)

    }
}
