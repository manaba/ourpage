package com.tammy.ourpage.controller;

import com.tammy.ourpage.model.Blog;
import com.tammy.ourpage.service.BlogService;
import com.tammy.ourpage.service.TagService;
import com.tammy.ourpage.service.TypeService;
import com.tammy.ourpage.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tammy on 16/6/18.
 */
@Controller
public class EditController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @RequestMapping(value={"/upload"})
    @ResponseBody
    public String ueditorImageUp(HttpServletRequest request, HttpServletResponse response, @RequestParam("imgFile") MultipartFile imgFile){
        String fname = null;
        System.out.println(request.toString());
        if(imgFile != null){
            response.setContentType("application/json");
            Resource r = new ClassPathResource("ApplicationContextBase.xml");
            String rootPath = null;
            try {
                rootPath = r.getFile().getParent();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            FileOutputStream out = null;
            rootPath = rootPath + "/static/upload";
            // 存放路径，如果不存在则创建路径
            File file = new File(rootPath);
            System.out.println(rootPath);
            if(!file.exists()) file.mkdirs();
            fname = imgFile.getOriginalFilename();
            try {
                out = new FileOutputStream(rootPath + "/" + fname);
                out.write(imgFile.getBytes());
                out.close();

                String imgUrl = "http://localhost:8080/static/upload/" + fname;
                JSONObject obj = new JSONObject();
                obj.put("error", 0);
                obj.put("url", imgUrl);
                return obj.toString();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return "FAIL";
    }

    @RequestMapping(value={"/fileUpload"})
    @ResponseBody
    public String inputUpload(HttpServletRequest request, HttpServletResponse response,@RequestParam("file_data") MultipartFile imgFile){
        String fname = null;
        System.out.println(request.toString());
        if(imgFile != null){
            response.setContentType("application/json");
            Resource r = new ClassPathResource("ApplicationContextBase.xml");
            String rootPath = null;
            try {
                rootPath = r.getFile().getParent();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            FileOutputStream out = null;
            rootPath = rootPath + "/static/upload";
            // 存放路径，如果不存在则创建路径
            File file = new File(rootPath);
            System.out.println(rootPath);
            if(!file.exists()) file.mkdirs();
            fname = imgFile.getOriginalFilename();
            try {
                out = new FileOutputStream(rootPath + "/" + fname);
                out.write(imgFile.getBytes());
                out.close();

                String imgUrl = "http://localhost:8080/static/upload/" + fname;
                JSONObject obj = new JSONObject();
                obj.put("code", 0);
                obj.put("message", "upload success!");
                obj.put("url",imgUrl);
                return obj.toString();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return "FAIL";
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

    @RequestMapping(value={"/addBlog"},method = RequestMethod.POST)
    @ResponseBody
    public String addBlogPost(String blogString) {
        System.out.println(blogString);
        JSONObject json= new JSONObject(blogString);
        Blog blog=new Blog();
        blog.setTitle(json.get("title").toString());
        blog.setContent(json.getString("blogContent"));
        blog.setTypeID(json.getInt("typeID"));
        blog.setImgTitle(json.getString("imgTitle"));
        JSONArray tags = json.getJSONArray("tagsID");
        if(tags.length()>0){
            String tagsID="";
            tagsID+=tags.getInt(0);
            for (int i=1;i<tags.length();i++){
                tagsID+=","+tags.getInt(i);
            }
            blog.setTagsID(tagsID);
        }
        blogService.insert(blog);
        JSONObject obj = new JSONObject();
        obj.put("success", true);
        obj.put("data", "upload success!");
        return obj.toString();
    }
}
