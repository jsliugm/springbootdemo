package com.universe.demo.test;

import com.universe.demo.springboot.SpringbootApplication;
import com.universe.demo.springboot.entity.Person;
import com.universe.demo.springboot.mapper.PersonMapper;
import com.universe.demo.springboot.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class PersonTest {
    @Resource
    private PersonService personService;

    @Resource
    private PersonMapper personMapper;

    //@Transactional
    @Test
    public void add() {
        personService.add(Person.builder().name("zhangsan").address("shanghai").build());
        // personService.add(new Person(111,"zhangsan123"));
    }

    @Test
    public void get() {
        List<Person> list = personMapper.select(Person.builder().name("zhangsan").address(null).build());
        System.out.println(list);
    }
}