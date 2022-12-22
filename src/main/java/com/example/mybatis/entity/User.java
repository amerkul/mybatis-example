package com.example.mybatis.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class User {

    private long id;
    private String name;
    private int salary;

    private Set<Book> books;

    public User(long id) {
        this.id = id;
    }
    public User(String name) {
        this.name = name;
    }

    public User(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public User (String name, int salary, Set<Book> books) {
        this.name = name;
        this.salary = salary;
        this.books = books;
    }

}
