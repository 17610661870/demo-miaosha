package com.example.demo.service.impl;

import com.example.demo.damain.User;
import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
