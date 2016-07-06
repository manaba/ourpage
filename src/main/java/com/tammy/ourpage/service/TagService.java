package com.tammy.ourpage.service;

import com.tammy.ourpage.dao.TagMapper;
import com.tammy.ourpage.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tammy on 16/5/7.
 */
@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;
    public List<Tag> getAllTags(){
        return  tagMapper.selectAllTags();
    }

    public Tag getTagByID(Integer id){
        return  tagMapper.selectByPrimaryKey(id);
    }

    public List<Tag> selectTagsByID(List<Integer> list){
        return tagMapper.selectTagsByID(list);
    }
}
