package com.example.demo.service;

import com.example.demo.annotation.LogAnnotation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: smart lihao
 * @Date: 2019/7/29 18:54
 */
@Service
@Transactional
public class AsyncService {


    //@Async
    @LogAnnotation
    public void test() throws InterruptedException {
        int i = 0;
        System.out.println("AsyncService.test");
        //i = 10 / i;

    }
}
