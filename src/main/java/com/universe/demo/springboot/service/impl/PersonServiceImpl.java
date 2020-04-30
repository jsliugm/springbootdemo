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

@Service
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
}
