package com.groovy.test

import groovy.sql.Sql

class TestSql {

    static void main(String... args) {
        def username = 'root'
        def password = '123123'
        def url = 'jdbc:mysql://127.0.0.1:3306/jpa?useUnicode=true&characterEncoding=utf8'
        def driver = 'com.mysql.jdbc.Driver'

        def tablename = 'weather'
//        def sql = Sql.newInstance(url,username,password,driver)
//        println(sql.connection.catalog)
//        println('City    ---      Weather    ')
//        def processMeta = {metaData->
//            metaData.columnCount.times{
//                i->
//                    printf("%-15s",metaData.getColumnLabel(i+1))
//            }
//            println(" ")
//        }
//        sql.eachRow("SELECT * FROM weather",processMeta){
//            printf("%-20s%s\n",it.city,it[1])
//        }

        //create xml data
//        def bldr = new MarkupBuilder()
//        bldr.weather{
//            sql.eachRow('SELECT * from weather'){
//                city(name:it.city,temp:it[1])
//            }
//        }

//        def dataSet = sql.dataSet('weather')
//        def belowZero = dataSet.findAll {it.temperature < 32}
//        println(belowZero.each {
//            println(it.city)
//        })
//        println('below zero ... ')
//        println('count: '+sql.rows('SELECT *FROM weather').size())
//        dataSet.add(city:'合肥',temperature:23)
//        println('count: '+sql.rows('SELECT *FROM weather').size())


        //visit excel
        def sql = Sql.newInstance(
                """
                jdbc:odbc:Driver={Microsoft Excel Driver(*.xls,*.xlsx,*.xlsm,*.xlsb)};
                DBQ=c:/code/temp.xlsx;READONLY=false
            """,'',''
        )
        println("City\t\tTemperature")
        sql.eachRow('SELECT *FROM weather'){
            println("${it.city}\t\t${it.temperature}")
        }
    }
}
