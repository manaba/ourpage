package com.tammy.ourpage.service;

import com.tammy.ourpage.dao.TypeMapper;
import com.tammy.ourpage.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tammy on 16/5/7.
 */
@Service
public class TypeService {
    @Autowired
    private TypeMapper typeMapper;
    public List<Type> getAllTypes(){
        return  typeMapper.selectAllTypes();
    }

    public Type getTypeByID(Integer id){
        return  typeMapper.selectByPrimaryKey(id);
    }
}
