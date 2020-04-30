package com.universe.demo.springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_person")
@Data
public class Person {
    @Id
    private long id;
    @Column
    private String name;
}
