package com.tammy.ourpage.service;

import com.tammy.ourpage.dao.BlogDao;
import com.tammy.ourpage.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tammy on 16/4/11.
 */
@Service
public class BlogService {
    @Autowired
    private BlogDao blogDao;
    public void insert(Blog blog){
        blogDao.insert(blog);
    }
}
