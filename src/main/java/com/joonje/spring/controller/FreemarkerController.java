package com.joonje.spring.controller;

import com.joonje.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joonje on 2015/3/26.
 */
@RestController
public class FreemarkerController {

    @RequestMapping(value = "/freemarker")
    public User testfreemarkerview(HttpServletRequest request, HttpServletResponse response) throws RuntimeException{
        ModelAndView mav = new ModelAndView();
        System.out.println("你的上传空间");
//        String str = "这是返回给freemarker页面的值";
//        mav.addObject("haha", str);

        ///这里顺便回顾下HashMap的使用方法
/*      创建：Map<String,String> map = new HashMap<String,String>();
        插入元素：map.put("1","a");
        移除元素: map.remove("1");
        清空: map.clear();*/
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("name", "xiaoming");
//        map.put("age", "21");
//        map.put("address", "硅谷");
//        map.put("ad", "广州");
//        map.remove("ad");
//        mav.addObject("maplist", map);
        User user = new User();
        user.setId("5");
        user.setName("joonje");
        user.setPassword("123");
        user.setSex("1");
        mav.addObject(user);
        mav.setViewName("hello");
        return user;
    }
}
