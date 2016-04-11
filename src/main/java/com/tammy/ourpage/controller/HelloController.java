package com.tammy.ourpage.controller;

import com.tammy.ourpage.model.Blog;
import com.tammy.ourpage.model.User;
import com.tammy.ourpage.service.BlogService;
import com.tammy.ourpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value={"/register"},method = RequestMethod.GET)
    public String registerGet(){
        return "register";
    }

    @RequestMapping(value={"/register"},method = RequestMethod.POST)
    @ResponseBody
    public String registerPost(String name,String password) {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userService.insert(user);
        return "success";
    }

    @RequestMapping(value={"/testBlog"},method = RequestMethod.POST)
    @ResponseBody
    public String testBlogPost(String title,String content) {
        Blog blog=new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blogService.insert(blog);
        return "success";
    }



}
