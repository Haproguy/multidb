package com.multidb.dbtodb.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "tst_muldb")
@Getter
public class MainTST {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "name", length = 16)
    private String name;

    @Column(name = "age")
    private int age;

    public String toString(){
        return "Man {" +
        "seq =" + seq +
        ", name =" + name  +
        ", age =" + age + '}';
    }
}
