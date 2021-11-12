package com.universe.demo.springboot.service;

import com.universe.demo.springboot.entity.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonService {
    List<Person> getAllPerson();
    void scan();
    void add(Person person);

    void add2(Person person);

    @Transactional
    void add();
}
