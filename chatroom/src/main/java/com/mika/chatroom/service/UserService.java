package com.mika.chatroom.service;

import com.mika.chatroom.mapper.UserMapper;
import com.mika.chatroom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public List<User> getUsersByName(String userName) {
        return userMapper.getUsersByName(userName);
    }
}
