package com.example.demo.Strategy;

import com.example.demo.bean.Hello;

/**
 * @Author: smart lihao
 * @Date: 2019/6/12 15:10
 */
public interface Strategy {

    abstract public void process(Hello orderDTO);
}
