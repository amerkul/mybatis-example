package com.example.mybatis.controller;

import com.example.mybatis.entity.Book;
import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.BookMapper;
import com.example.mybatis.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/rest/users")
public class UserController {

    private UserMapper userMapper;
    private BookMapper bookMapper;

    @GetMapping("/all")
    public List<User> getAll() {
        return userMapper.findAll();
    }

    @GetMapping("/insert")
    public List<User> update() {
        User user = new User("Kim", 5000, Set.of(new Book("Zombi")));
        userMapper.insert(user);
        log.info("User generated ID = " + user.getId());
        for (Book book : user.getBooks()) {
            bookMapper.insert(book, user.getId());
        }
        return userMapper.findAll();
    }

    @GetMapping("/updateUsers")
    public List<User> updateUsers() {
        User user = new User("Anna", 10000);
        userMapper.update(user);
        return userMapper.findAll();
    }

    @GetMapping("/delete")
    public List<User> delete() {
        User user = new User("Kim");
        userMapper.delete(user);
        return userMapper.findAll();
    }

    @GetMapping("user/{id}/books")
    public Set<Book> getUserBooks(@PathVariable("id") String userId) {
        return userMapper.findAllBooks(userId);
    }

}
