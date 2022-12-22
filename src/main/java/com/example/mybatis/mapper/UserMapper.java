package com.example.mybatis.mapper;

import com.example.mybatis.entity.Book;
import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {

    @Select("SELECT user_id, name, salary FROM users")
    @Results(value = {
            @Result(property = "id", column = "user_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "salary", column = "salary"),
            @Result(property = "books", column = "user_id", javaType = Set.class, many = @Many(select = "findAllBooks"))
    })
    List<User> findAll();

    @Select("SELECT book_id, name FROM books WHERE user_id = #{userId}")
    @Results(value = {
            @Result(property = "id", column = "book_id"),
            @Result(property = "name", column = "name")
    })
    Set<Book> findAllBooks(@Param("userId") String userId);

    @Insert("INSERT INTO users(name, salary) VALUES(#{name}, #{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    void insert(User user);

    @Update("UPDATE users SET salary=#{salary} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM users WHERE name=#{name}")
    void delete(User user);

}
