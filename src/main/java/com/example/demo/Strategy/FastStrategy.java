package com.example.demo.Strategy;

import com.example.demo.annotation.StrategyTypeAnnotation;
import com.example.demo.bean.Hello;
import com.example.demo.enums.StrategyTypeEnum;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: smart lihao
 * @Date: 2019/6/12 15:11
 */
@Service
@StrategyTypeAnnotation(StrageType = StrategyTypeEnum.BOOKING)
public class FastStrategy implements Strategy{
    private Lock lock = new ReentrantLock();
    @Override
    public void process(Hello orderDTO) {

    }


    public void b(){
        try {

            lock.lock();

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " run");
    }




}
