package com.example.demo.bean;

import com.example.demo.enums.CodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: smart lihao
 * @Date: 2019/3/24 16:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> implements Serializable{

    private Integer code;

    private String msg;

    private T data;


    public static ResultVO success(){
        return new ResultVO<>(CodeStatus.CODE_SUCCESS.getState(),
                CodeStatus.CODE_SUCCESS.getMsg(),null);
    }

    public static ResultVO success(Object obj){
        return new ResultVO<>(CodeStatus.CODE_SUCCESS.getState(),
                CodeStatus.CODE_SUCCESS.getMsg(),obj);
    }

    public static ResultVO success(CodeStatus codeStatus){
        return new ResultVO<>(codeStatus.getState(),
                codeStatus.getMsg(),null);
    }

    public static ResultVO fail(CodeStatus codeStatus){
        return new ResultVO<>(codeStatus.getState(),
                codeStatus.getMsg(),null);
    }

    public static ResultVO fail(CodeStatus codeStatus,Object object){
        return new ResultVO<>(codeStatus.getState(),
                codeStatus.getMsg(),object);
    }

}
