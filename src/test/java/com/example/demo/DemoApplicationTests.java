package com.example.demo;

import com.example.demo.bean.CalledList;
import com.example.demo.bean.Hello;
import com.example.demo.bean.WechatPush;
import com.example.demo.config.FactoryBeanDemo;
import com.example.demo.mapper.CalledListMapper;
import com.example.demo.mapper.WechatPushMapper;
import com.example.demo.service.MybatisService;
import com.example.demo.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    /*@Autowired
    private FactoryBeanDemo hello;*/
    @Resource
    private MybatisService mybatisService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private TestService testService;


    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().setBit("key", 1, true);


    }


    @Test
    public void test() {

        Object key = redisTemplate.opsForValue().get("key");
        System.out.println(key + "---------------------------------------");


    }


    @Test
    public void test1() throws InterruptedException {

        testService.test();


    }

    @Resource
    private CalledListMapper calledListMapper;

    @Resource
    private WechatPushMapper wechatPushMapper;

    @Test
    public void mappertest1() {
        CalledList calledList = new CalledList();
        WechatPush wechatPush = wechatPushMapper.selectByPrimaryKey("uuidassqwqwq");
        Optional<WechatPush> optionalCalledList = Optional.ofNullable(wechatPush);
        optionalCalledList.ifPresent(new Consumer<WechatPush>() {
            @Override
            public void accept(WechatPush wechatPush) {
                calledListMapper.insert(calledList);
                System.out.println("不是null");
            }
        });
        System.out.println(optionalCalledList.isPresent());

    }


    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setName("1");
        Hello hello1 = new Hello();
        hello1.setName("2");
        List<Hello> list = new ArrayList<>();
        list.add(hello);
        list.add(hello1);
        List<Hello> collect = list.stream().filter(a -> a.getName() == "1")
                //.map(Hello::getName)
                .collect(Collectors.toList());
        System.out.println(collect);


    }
}
