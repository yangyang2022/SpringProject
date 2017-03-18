package com.yangyang.service;

import com.yangyang.dao.PersonRepository;
import com.yangyang.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    @Override
    public void updatePersonEmail(Integer id, String email) {
        personRepository.updatePersonEmail(id,email);
    }

    @Transactional
    @Override
    public Stream<Person> findPersons() {
        return personRepository.findPersons();
    }
}
