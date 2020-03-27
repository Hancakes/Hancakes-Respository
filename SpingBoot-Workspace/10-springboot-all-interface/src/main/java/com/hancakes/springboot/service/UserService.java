package com.hancakes.springboot.service;

import com.hancakes.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /*分页查询*/
    List<User> getUserByPage(Map<String,Object> paramMap);
    /*分页查询需要数据总数*/
    int getUserByTotal();

    //添加用户
     int addUser(User user);
    //修改用户
     int updateUser(User user);
     User getUserById(Integer id);
    //删除用户
     int deleteUser(Integer id);
}
