package com.tammy.ourpage.controller;

import com.tammy.ourpage.model.User;
import com.tammy.ourpage.service.BlogService;
import com.tammy.ourpage.service.TagService;
import com.tammy.ourpage.service.TypeService;
import com.tammy.ourpage.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tammy on 16/6/28.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value={"/registerPost"},method = RequestMethod.GET)
    public String registerPost(String email,String name,String password){
        User user=new User();
        user.setEmail(email);
        user.setUname(name);
        user.setPassword(password);
        userService.insert(user);
        return "success";
    }

    @RequestMapping(value={"/loginPost"},method = RequestMethod.GET)
    public String loginPost(String email,String password){
        Integer userId=-1;
        Cookie cookies[] =request.getCookies();
        for(int i=0;i<cookies.length;i++) {
            if (cookies[i].getName().equals("userid")) {
                userId=Integer.parseInt(cookies[i].getValue());
            }
        }

        User user = null;
        if(userId!=-1){
            user=userService.selectByID(userId);
        }else {
            user = userService.selectByEmailAndPswd(email,password);
        }

        JSONObject jsonObject = new JSONObject(user);
        if (user==null)
            return "fail";
        else{
//	        	Cookie user = new Cookie("username",username+"-"+rs.getString("email")+"-"+String.valueOf(rs.getInt("userid"))+"-"+rs.getString("Mobile"));
            Cookie cook = new Cookie("userid", String.valueOf(user.getIduser()));
            cook.setMaxAge(14 * 24 * 60 * 60); //两个星期
            //cook.setPath("/");
            response.addCookie(cook);

            return jsonObject.toString();
        }

    }

}
