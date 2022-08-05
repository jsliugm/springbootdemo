package com.universe.demo.config;

import com.universe.demo.springboot.service.PersonService;
import com.universe.demo.springboot.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class PersonConfig {
    @Configuration
    protected static class PersonBeanCreator{
        @Bean
        public PersonService personService2(){
            System.out.println("");
            return new PersonServiceImpl();
        }
    }
}

