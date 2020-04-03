package com.hancakes.dao;

import com.hancakes.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    void saveUser(User user);

    User eqNameAndPass(@Param("username")String username,@Param("password") String password);
}
