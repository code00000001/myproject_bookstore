package com.bookstore.service.impl;

import com.bookstore.mapper.UserMapper;
import com.bookstore.pojo.User;
import com.bookstore.pojo.UserExample;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> users = userMapper.selectByExample(example);
        if (users != null){
            return users.get(0);
        }
        return null;
    }
}
