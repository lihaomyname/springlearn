package com.example.demo.controller;

import com.example.demo.config.RejectedExecutionHandlerImpl;
import com.example.demo.enums.Status;
import com.example.demo.utils.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @Author: smart lihao
 * @Date: 2019/5/2 14:12
 */
@RestController
public class DemoController {

    @Autowired
    private FastDFSClientWrapper dfsClient;

    @Value("${app}")
    private String app;


    private String dev;

    // 上传图片
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        // 省略业务逻辑代码。。。
        String referer = request.getHeader("Referer");
        String demo="";
        System.out.println(file);
        String imgUrl = null;
        byte[] bytes = new byte[0];
        OutputStream outputStream = null;
        try {
            bytes = file.getBytes();
            File file1 = new File("C:/lihao/x.jpg");
            outputStream = new FileOutputStream(file1);
            outputStream.write(bytes);
            outputStream.close();
            imgUrl = dfsClient.uploadFile(file);
        } catch (IOException e) {
            System.out.println("");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e1) {
                    System.out.println("");
                    //e1.printStackTrace();
                }
            }
        }
        return imgUrl;
    }


    @RequestMapping(value = "/app")
    public String getStr() throws InterruptedException {
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                4,
                5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1), threadFactory, rejectionHandler);
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run");
            }
        };

        /*executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("jjjjjjjjjjjj");
            }
        });*/
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---先开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---再开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        Thread.sleep(8000);
        System.out.println("----8秒之后----");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());

        /*while (!future.isDone()){
            System.out.println("没有完成");


        }*/

        //System.out.println(future.isDone());
        //executor.shutdown();
        executor.shutdown();
        return app;
    }


    public static void main(String[] args) {
        int i = 1 << 30;
        System.out.println(i);
        Status status = Status.getByStatusCode(1);
        status.run();


    }


}
