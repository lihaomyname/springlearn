package com.example.demo.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: smart lihao
 * @Date: 2019/6/13 16:59
 */
@RestController
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;


    public String doRedis(){

        redisTemplate.opsForValue().setBit("key",1,true);


        return null;
    }


}
