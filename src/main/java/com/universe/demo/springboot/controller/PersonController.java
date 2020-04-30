package com.universe.demo.springboot.controller;

import com.universe.demo.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
