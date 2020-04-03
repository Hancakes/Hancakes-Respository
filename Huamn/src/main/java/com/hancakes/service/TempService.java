package com.hancakes.service;

import com.hancakes.entity.Temp;

import java.util.List;

public interface TempService {
    void insertTemp(Temp temp);

    List<Temp> selectTemp();

    Temp updatebyid(String id);

    void getUpdate(Temp temp);

    void delete(String id);
}
