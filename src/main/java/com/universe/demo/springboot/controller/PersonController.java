package com.universe.demo.springboot.controller;

import com.universe.demo.springboot.entity.Person;
import com.universe.demo.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/person/all")
    public Object all() {
        return personService.getAllPerson();
    }

    @RequestMapping("/person/scan")
    public void scan() {
        personService.scan();
    }

    @RequestMapping("/person/update")
    @ResponseBody
    public Object update(@RequestBody @Valid Person person) {
        System.out.println(person.getName());
        return person.getName();
    }
}
