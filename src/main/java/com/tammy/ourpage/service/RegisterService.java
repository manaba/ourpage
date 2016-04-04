package com.tammy.ourpage.service;

import com.tammy.ourpage.dao.RegisterDao;
import com.tammy.ourpage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterDao registerDao;

    public void insert(User user){
        registerDao.insert(user);
    }
}
