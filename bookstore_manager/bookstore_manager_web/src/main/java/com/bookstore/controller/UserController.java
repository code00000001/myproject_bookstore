package com.bookstore.controller;

import com.bookstore.pojo.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * @PathVariable 接收请求url中占位符的值
     * @param userId
     * @return
     */
    @RequestMapping("user/{userId}")
    public User getUserById(@PathVariable Integer userId){
        User user = userService.getUserById(userId);
        return user;
    }
}
