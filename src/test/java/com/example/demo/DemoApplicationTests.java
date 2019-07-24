package com.example.demo;

import com.example.demo.bean.Hello;
import com.example.demo.config.FactoryBeanDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	/*@Autowired
	private FactoryBeanDemo hello;*/


	@Resource
	private RedisTemplate redisTemplate;



	@Test
	public void contextLoads() {
		redisTemplate.opsForValue().setBit("key",1,true);


	}


	@Test
	public void test() {

        Object key = redisTemplate.opsForValue().get("key");
        System.out.println(key+"---------------------------------------");


    }
}
