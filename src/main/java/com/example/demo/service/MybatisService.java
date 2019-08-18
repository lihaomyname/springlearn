package com.example.demo.service;

import com.example.demo.bean.WechatPush;
import com.example.demo.mapper.WechatPushMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: smart lihao
 * @Date: 2019/7/29 18:27
 */
@Service
@Transactional
@Slf4j
public class MybatisService {

    @Resource
    private WechatPushMapper wechatPushMapper;

    @Resource
    private AsyncService asyncService;

    public void add() throws InterruptedException {

        WechatPush wechatPush = new WechatPush();
        wechatPush.setMessage("12");
        wechatPush.setMessageId("12");
        wechatPush.setSessionId("uuidassqwqwq");
        wechatPush.setOpenid("123");
        wechatPush.setInsTime(new Date());
        wechatPushMapper.insert(wechatPush);
        asyncService.test();
    }

    @Async
    public void test() throws InterruptedException {
        int i = 0;
        Thread.sleep(10000L);
        i = 10 / i;

    }


}
