package com.yangyang.service;

import com.yangyang.model.Person;

import java.util.stream.Stream;

/**
 * Created by syy on 2017/3/10.
 */
public interface IPersonService {
    void updatePersonEmail(Integer id,String email);
    Stream<Person> findPersons();
}
