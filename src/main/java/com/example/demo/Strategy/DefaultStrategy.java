package com.example.demo.Strategy;

import com.example.demo.bean.Hello;
import com.example.demo.config.RejectedExecutionHandlerImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: smart lihao
 * @Date: 2019/6/12 15:11
 */
@Service
public class DefaultStrategy implements Strategy {
    @Override
    public void process(Hello orderDTO) {

    }


    public static void main(String[] args) {
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                4,
                5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1),threadFactory,rejectionHandler);
        FastStrategy fastStrategy = new FastStrategy();
        Runnable myRunnable=new Runnable() {
            @Override
            public void run() {
               /* Lock lock = new ReentrantLock();
                try {

                    boolean b = lock.tryLock();
                    System.out.println(b);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName() + " run");*/
                fastStrategy.b();
            }
        };

        Future<?> submit = executor.submit(myRunnable);
        Future<?> submit1 = executor.submit(myRunnable);


    }
}
