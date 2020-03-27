package com.hancakes.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hancakes.springboot.mapper.UserMapper;
import com.hancakes.springboot.model.User;
import com.hancakes.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component //spring的注解
@Service//dubbo的注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {
        return userMapper.selectUserByPage(paramMap);
    }

    @Override
    public int getUserByTotal() {
        //设置Key的序列化方式，采用字符串方式，可以读性较好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //取redis总数
        Integer totalRows = (Integer) redisTemplate.opsForValue().get("totalRows");
        if(totalRows == null){

            synchronized (this){
                totalRows = (Integer) redisTemplate.opsForValue().get("totalRows");

                if( totalRows == null){
                    totalRows = userMapper.selectUserByTotal();
                    redisTemplate.opsForValue().set("totalRows",totalRows);
                }
            }
        }
        return totalRows;
    }

    @Override
    public int addUser(User user) {
        //设置Key的序列化方式，采用字符串方式，可以读性较好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int add = userMapper.insertSelective(user);
        //如果>0 则添加成功
        if(add > 0 ){
            //更新一下缓存的总数
            int totalRows = userMapper.selectUserByTotal();
            redisTemplate.opsForValue().set("totalRows",totalRows);
        }
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteUser(Integer id) {
        //设置Key的序列化方式，采用字符串方式，可以读性较好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int delete = userMapper.deleteByPrimaryKey(id);
        //如果>0 则删除成功
        if(delete > 0 ){
            //更新一下缓存的总数
            int totalRows = userMapper.selectUserByTotal();
            redisTemplate.opsForValue().set("totalRows",totalRows);
        }
        return delete;
    }
}
