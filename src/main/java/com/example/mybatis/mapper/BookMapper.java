package com.example.mybatis.mapper;

import com.example.mybatis.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    @Insert("INSERT INTO books(name, user_id) VALUE(#{book.name}, #{userId})")
    void insert(Book book, long userId);

}
