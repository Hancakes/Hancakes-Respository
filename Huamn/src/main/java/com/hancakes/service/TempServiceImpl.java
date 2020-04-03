package com.hancakes.service;

import com.hancakes.dao.TempDao;
import com.hancakes.entity.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TempServiceImpl implements TempService{

    @Autowired
    private TempDao tempDao;

    @Override
    public void insertTemp(Temp temp) {
        temp.setId(UUID.randomUUID().toString());
        tempDao.insert(temp);

    }

    @Override
    public List<Temp> selectTemp() {

        return tempDao.selectTemp();
    }

    @Override
    public Temp updatebyid(String id) {
        return tempDao.updatebyid(id);
    }

    @Override
    public void getUpdate(Temp temp) {
        tempDao.getUpdate(temp);
    }

    @Override
    public void delete(String id) {
        tempDao.delete(id);
    }


}

