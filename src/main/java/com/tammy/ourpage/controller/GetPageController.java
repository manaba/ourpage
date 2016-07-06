package com.tammy.ourpage.controller;

import com.tammy.ourpage.model.Blog;
import com.tammy.ourpage.model.Tag;
import com.tammy.ourpage.model.Type;
import com.tammy.ourpage.model.User;
import com.tammy.ourpage.service.BlogService;
import com.tammy.ourpage.service.TagService;
import com.tammy.ourpage.service.TypeService;
import com.tammy.ourpage.service.UserService;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class GetPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;


    @RequestMapping(value={"/record"},method = RequestMethod.GET)
    public String recordGet(){
        return "record";
    }

    @RequestMapping(value={"/test_editor"},method = RequestMethod.GET)
    public String ueditorGet(){
        return "wangeditor_test";
    }

    @RequestMapping(value={"/test_kindeditor"},method = RequestMethod.GET)
    public String kindeditorGet(){
        return "kindeditor";
    }

    @RequestMapping(value={"/blog"},method = RequestMethod.GET)
    public String blogPageGet(ModelMap modelMap){
        //System.out.println("blog");
        List<Blog> blogFirstPage=blogService.selectBlogPage(1,5);
        System.out.println(blogFirstPage.size());
        modelMap.addAttribute("listBlog",blogFirstPage);
        return "page_blog_list";
    }

    @RequestMapping(value={"/blogeditor"},method = RequestMethod.GET)
    public String blogEditorGet(ModelMap modelMap){
        List<Tag> allTags=tagService.getAllTags();
        List<Type> allTypes=typeService.getAllTypes();
        modelMap.addAttribute("listTag",allTags);
        modelMap.addAttribute("listType",allTypes);
        return "page_blog_edit";
    }

    /**
     * 博客详细的页面
     * @return
     */
    @RequestMapping(value={"/blogDetail"},method = RequestMethod.GET)
    public String blogDetailGet(ModelMap modelMap,Integer id){
        Blog blog = blogService.selectByID(id);
        blog.setReadCount(blog.getReadCount()+1);
        blogService.updateBlog(blog);
        modelMap.addAttribute("blog",blog);
        return "page_blog_detail";
    }

    @RequestMapping(value={"/login"},method = RequestMethod.GET)
    public String loginPageGet(){
        return "page_login";
    }


    /**
     * 获得注册的页面
     * @return 注册页面
     */
    @RequestMapping(value={"/register"},method = RequestMethod.GET)
    public String registerGet(){
        return "register";
    }




//    @RequestMapping(value = {"/upload"},method = RequestMethod.POST)
//    @ResponseBody
//    public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String path = request.getRealPath("/image");
//        File file = new File(path);
//        if (!file.exists())
//            file.mkdirs();
//        String fileName = "";// 文件名称
//
//
//        /**上传文件处理内容**/
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload sfu = new ServletFileUpload(factory);
//        sfu.setHeaderEncoding("UTF-8"); // 处理中文问题
//        sfu.setSizeMax(1024 * 1024); // 限制文件大小
//        try {
//            List fileItems = sfu.parseRequest(request); // 解码请求
//            for (Object fi : fileItems) {
//                FileItem fii=(FileItem)fi;
//                fileName = UUID.randomUUID()+fii.getName().substring(fii.getName().lastIndexOf("."),fii.getName().length());
//                fii.write(new File(path, fileName));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        /**********************/
//
//        //获取图片url地址
//        String imgUrl = "http://localhost:8080/wang_editor_demo/image/" + fileName;
//        response.setContentType("text/text;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.print(imgUrl);  //返回url地址
//        out.flush();
//        out.close();
//        return imgUrl;
//    }





}
