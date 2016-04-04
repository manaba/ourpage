package com.tammy.ourpage.dao;

import java.util.List;

import com.tammy.ourpage.model.User;

public interface RegisterDao {

    public void insert(User user) ;

    public List<User> select();
}

