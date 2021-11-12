package com.universe.demo.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_person")
@Data
public class Person {
    @Id
    private Long id;
    @NotNull
    @Column
    private String name;
    @Column
    private String address;
}
