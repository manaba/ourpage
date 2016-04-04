package com.tammy.ourpage.controller;

import com.tammy.ourpage.model.User;
import com.tammy.ourpage.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private RegisterService registerService;

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
        registerService.insert(user);
        return "success";
    }

}
