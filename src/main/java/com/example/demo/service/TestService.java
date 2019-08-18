package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: smart lihao
 * @Date: 2019/7/29 19:10
 */
@Service
public class TestService {

    @Resource
    private AsyncService asyncService;

    public void test() throws InterruptedException {

        asyncService.test();

    }

}
