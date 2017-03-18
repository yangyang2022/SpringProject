package com.groovy.Demo

import com.fasterxml.jackson.annotation.JsonFilter
import groovy.transform.ToString

import java.time.LocalDate

@ToString@JsonFilter("jsonfilter")
class Orgernazation implements Serializable {

    String name
    String description

    @Lazy
    def users = {
        println("init ... ")
        [
                 new User(username: 'shen1',password: 123123,loginName: 'yangyang1',age: 12,birth: LocalDate.now(),orgernazation: this),
                 new User(username: 'shen2',password: 123123,loginName: 'yangyang2',age: 12,birth: LocalDate.now().minusYears(1),orgernazation: this),
                 new User(username: 'shen3',password: 123123,loginName: 'yangyang3',age: 13,birth: LocalDate.now().minusYears(2),orgernazation: this),
        ]
    }()
    static void main(String ...args){

        def org = new Orgernazation()
        println "================  ================ "
        println("users: $org.users")

        println "user.class.name ${org.users.class.simpleName}"

    }
}
