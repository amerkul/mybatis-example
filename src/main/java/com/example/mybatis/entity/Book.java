package com.example.mybatis.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Book {

    private long id;
    private String name;

    public Book(String name) {
        this.name = name;
    }

}
