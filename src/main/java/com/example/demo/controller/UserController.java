package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.damain.User;
import com.example.demo.redis.RedisService;
import com.example.demo.result.ResultData;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;


    @RequestMapping("getAllUser")
    @ResponseBody
    public ResultData<List> getAllUser(){
        List<User> users = userService.getAllUser();
        return ResultData.success(users);
    }
    @RequestMapping("dologin")
    public String do_login(){

        return "index";
    }
    @RequestMapping("redisGet")
    @ResponseBody
    public ResultData<String> redisGet(){
        String str = redisService.get("aaa",String.class);
        return ResultData.success(str.toString());
    }
    @RequestMapping("redisSet")
    @ResponseBody
    public ResultData<Boolean> redisSet(){
        boolean b = redisService.set("aaa","qwe");
        return ResultData.success(b);
    }
}
