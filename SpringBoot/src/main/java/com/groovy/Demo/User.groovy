package com.groovy.Demo

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.ToString

import java.time.LocalDate

@ToString
class User implements Serializable {
    String username
    String loginName
    String password
    int age
    LocalDate birth
    @JsonIgnore
    Orgernazation orgernazation;

}
