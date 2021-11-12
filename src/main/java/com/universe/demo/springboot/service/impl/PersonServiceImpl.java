package com.universe.demo.springboot.service.impl;

import com.universe.demo.springboot.entity.Person;
import com.universe.demo.springboot.mapper.PersonMapper;
import com.universe.demo.springboot.service.PersonService;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 事务失效的原因是切面处没有事务
 */

public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<Person> getAllPerson() {
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void scan() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Cursor<Person> cursor = sqlSession.getMapper(PersonMapper.class).scan();
        cursor.forEach(person -> {
            System.out.println(person.getName());
        });
    }
   // @Transactional
    @Override
    public void add(Person person) {
        personMapper.insert(person);
    }
    @Override
    public void add2(Person person){
        add(person);
    }
    @Transactional
    public void add3(Person person){
        personMapper.insert(person);
        int a = 1/0;
    }
    @Transactional
    @Override
    public void add(){
        personMapper.insert(Person.builder().name("zhangsan1").address("address1").build());
        personMapper.insert(Person.builder().name("zhangsan2").address("address2").build());
        int a = 1/0;
        personMapper.insert(Person.builder().name("zhangsan2").address("address2").build());
    }
}
