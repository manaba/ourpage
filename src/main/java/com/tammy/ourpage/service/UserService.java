package com.tammy.ourpage.service;

import com.tammy.ourpage.dao.UserMapper;
import com.tammy.ourpage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tammy on 16/4/12.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void insert(User user){
        userMapper.insert(user);
    }

    public User selectByEmailAndPswd(String email,String password){
        return userMapper.selectByEmailAndPswd(email,password);
    }

    public User selectByID(Integer id){
        return  userMapper.selectByPrimaryKey(id);
    }
}
