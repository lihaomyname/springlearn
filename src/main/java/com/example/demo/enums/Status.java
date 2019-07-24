package com.example.demo.enums;

import com.example.demo.bean.Hello;

/**
 * @Author: smart lihao
 * @Date: 2019/6/12 13:51
 */
public enum Status {



    NEW(0){
        @Override
        public void run() {
            System.out.println("new");
        }
    },

    RUNNABLE(1){
        @Override
        public void run() {
            System.out.println("runnable");
        }
    };


    private int statusCode;

    public  void run(){
        System.out.println("wu");
    };

    Status(int statusCode){
        this.statusCode=statusCode;
    }


    public static Status getByStatusCode(int code){
        for (Status status:values()) {
            if(status.statusCode==code){
                return status;
            }
        }

        return null;
    }

}
