package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;

/**
 * @Author: smart lihao
 * @Date: 2019/5/2 14:10
 */
@Configuration
public class BeanConfig {

    @Bean(name = "myfactory")
    public FactoryBeanDemo getFactBean(){
        FactoryBeanDemo factoryBeanDemo = new FactoryBeanDemo();
        factoryBeanDemo.setBeanName("myfactory");
        return factoryBeanDemo;
    }


    public static void main(String[] args) {




        int integer = 16;
        String str ="AaB";
        int st =hash(str);
        int y=st%64;
        System.out.println(st);

        int demo = integer&st;
        System.out.println(y);

        List list=new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("BBB","1");
        hashMap.put("AaB","1");
        hashMap.put("adas","1");
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                10,
                1L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(5),threadFactory,rejectionHandler);
        //threadPoolExecutor.submit();

        Future<?> future = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("jjjjjjjjjjjj");
            }
        });
        boolean done = future.isDone();
       /* while (!done){
            System.out.println("!done");
        }*/
        System.out.println("done");
    }

    static  int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
