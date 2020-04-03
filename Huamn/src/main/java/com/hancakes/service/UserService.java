package com.hancakes.service;

import com.hancakes.entity.User;

public interface UserService {
    //注册用户
    void addUser(User user);

    //登陆
    User login(String username,String password);

    //添加

}
