package com.universe.demo.springboot.config;

import com.universe.demo.springboot.service.PersonService;
import com.universe.demo.springboot.service.impl.PersonService2Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PersonConfig2 {
    //@ConditionalOnMissingBean(PersonService.class)
    @Bean("personService2")
    public PersonService personService2() {
        log.info("^^^^^personService2");
        return new PersonService2Impl();
    }
}
