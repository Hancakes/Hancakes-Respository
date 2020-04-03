package com.hancakes;

import com.hancakes.dao.UserDao;
import com.hancakes.entity.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest( classes = HuamnApplication.class)
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    private UserDao userDao;

    @org.junit.Test
    public void saveUser(){
        userDao.saveUser(new User(UUID.randomUUID().toString(),"ZZ","陈明","123456","男"));
    }
}
