package com.example.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: smart lihao
 * @Date: 2019/7/6 10:50
 */
public class TreeMapDemo {


    public static void main(String[] args) {
       /* TreeMap treeMap = new TreeMap();
        treeMap.put("hhh","1");
        treeMap.put("sss","1");
        treeMap.put("sad","1");
        System.out.println(treeMap);*/
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("hhh","1");
        linkedHashMap.put("sss","1");
        linkedHashMap.put("sad","1");
        System.out.println(linkedHashMap);
       // ConcurrentHashMap





    }
}
