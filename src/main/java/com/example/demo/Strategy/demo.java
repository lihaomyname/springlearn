package com.example.demo.Strategy;

import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: smart lihao
 * @Date: 2019/7/11 13:10
 */
public class demo implements Runnable{

    private static volatile Double sensorValue;
    @Override
    public void run() {
        // 这里就是一个专有线程，不停读取传感器的值，由于sensorValue是包装类型，所以会不断产生新的对象
        while (true) {
            sensorValue = Math.random();
        }
    }

    private static void processSensorValue(Double value) {
        // 虽然形参没有真正被赋值给任一引用，但是这里是模拟了外部传入值，这里会进行各种操作
        if (value != null) {
            // Be warned: may take more than one usec on some machines, especially Windows
            LockSupport.parkNanos(1000);
        }
    }

    public static void main(String[] args) {
        int iterations = args.length > 0 ? Integer.parseInt(args[0]) : 30_000_000;

        initSensor();

        for (int i = 0; i < iterations; i++) {
            processSensorValue(sensorValue);
        }
    }

    private static void initSensor() {
        Thread sensorReader = new Thread(new demo());
        // 当主线程结束时守护线程自动结束
        sensorReader.setDaemon(true);
        sensorReader.start();
    }


}
