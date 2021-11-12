package com.universe.demo.test;

import com.universe.demo.springboot.SpringbootApplication;
import com.universe.demo.springboot.entity.Person;
import com.universe.demo.springboot.mapper.PersonMapper;
import com.universe.demo.springboot.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class PersonTest {
    @Resource
    private PersonService personService;

    @Resource
    private PersonMapper personMapper;

    @Rollback(false)
    @Transactional
    @Test
    public void add() {
        for (int i = 0; i < 3; i++) {
            personService.add(Person.builder().name("zhangsan" + i).address(null).build());
            if (i == 2) {
                throw new RuntimeException("eeeeeeee");
            }
        }
        //personService.add(new Person(111L,"zhangsan123",""));
//        try {
//            personService.add();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void get() {
        // List<Person> list = personMapper.select(Person.builder().name("zhangsan2").build());
        //System.out.println(list);
        Person person = personMapper.selectByPrimaryKey(3L);
        System.out.println();
    }
}