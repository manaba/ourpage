package com.tammy.ourpage.service;

import com.tammy.ourpage.dao.BlogMapper;
import com.tammy.ourpage.dao.TagMapper;
import com.tammy.ourpage.dao.TypeMapper;
import com.tammy.ourpage.model.Blog;
import com.tammy.ourpage.model.Tag;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tammy on 16/4/11.
 */
@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TagMapper tagMapper;

    public void insert(Blog blog){
        blogMapper.insert(blog);
    }

    public List<Blog> selectBlogPage(Integer page,Integer numPerPage){
        List<Blog> list= blogMapper.selectBlogPage((page-1)*numPerPage,numPerPage);
        for (int i=0;i<list.size();i++){
            Blog blog = list.get(i);
            blog.setCleanedContent(cleanHtml(blog.getContent()));
        }
        return  list;
    }

    public Blog selectByID(Integer id){
        Blog blog = blogMapper.selectByPrimaryKey(id);
        blog.setTypeName(typeMapper.selectByPrimaryKey(blog.getTypeID()).getTname());
        //blog.setTags(tagService.selectTagsByID(blog.getTagsID()));
//        List<Integer> list=new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
        List<Tag> tags=tagMapper.selectTagsByID(str2list(blog.getTagsID()));
        blog.setTags(tags);
        return blog;
    }

    private String cleanHtml(String htmlStr){
        String destStr = htmlStr.replaceAll("<img.*>.*</img>", "").replaceAll("<img.*/>", "");
        System.out.println(destStr);
        return destStr;
    }

    private List<Integer> str2list(String str){
        String [] strArr=str.split(",");
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<strArr.length;i++){
            list.add(Integer.parseInt(strArr[i]));
        }
        return list;
    }

    public void updateBlog(Blog blog){
        blogMapper.updateByPrimaryKey(blog);
    }
}
