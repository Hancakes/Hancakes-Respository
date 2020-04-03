package com.hancakes.service;

import com.hancakes.dao.UserDao;
import com.hancakes.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.eqNameAndPass(username,password);
    }
}
