package com.universe.demo.springboot.config;


import com.universe.demo.springboot.service.PersonService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    private PersonService personService;
    //这里会自动注入，懂了吗？
    public JavaConfig(PersonService personService) {
        this.personService = personService;
    }
}
