package com.hancakes.dao;

import com.hancakes.entity.Temp;

import java.util.List;

public interface TempDao {
    List<Temp> selectTemp();

    void insert(Temp temp);

    Temp updatebyid(String id);

    void getUpdate(Temp temp);

    void delete(String id);
}
