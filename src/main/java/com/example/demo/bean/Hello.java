package com.example.demo.bean;

import lombok.Builder;

/**
 * @Author: smart lihao
 * @Date: 2019/5/2 14:08
 */
public class Hello {


    static class RunnableDemo implements Runnable{

        private volatile int count=5;

        @Override
        public void run() {
            //count=count-1;
            System.out.println(Thread.currentThread().getName()+"count="+count++);
        }
    }

    static class ThreadDemo  extends Thread{


        @Override
        public void run() {
            System.out.println("Thread");
        }
    }


    public static void main(String[] args) throws InterruptedException {
      /*  System.out.println(Thread.currentThread().getName());
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();*/

        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread1 = new Thread(runnableDemo,"thread1");
        Thread thread2 = new Thread(runnableDemo,"thread2");
        Thread thread3 = new Thread(runnableDemo,"thread3");
        Thread thread4 = new Thread(runnableDemo,"thread4");
        Thread thread5 = new Thread(runnableDemo,"thread5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        System.out.println(thread5.isAlive());

        Thread.sleep(2);

        System.out.println(thread5.isAlive());

    }


    private String name;

    private String addr;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}



