package com.universe.demo.springboot.config;

import com.universe.demo.springboot.service.PersonService;
import com.universe.demo.springboot.service.impl.PersonService3Impl;
import com.universe.demo.springboot.service.impl.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PersonConfig {
    @ConditionalOnMissingBean(PersonService.class)
    @Bean
    public PersonService personService() {
        log.info("^^^^^personService1");
        return new PersonServiceImpl();
    }

    @ConditionalOnSingleCandidate(PersonService.class)
    @Bean
    public PersonService personService3() {
        log.info("^^^^^personService3");
        return new PersonService3Impl();
    }
}
