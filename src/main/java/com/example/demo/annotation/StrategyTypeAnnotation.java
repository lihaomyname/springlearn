package com.example.demo.annotation;

import com.example.demo.enums.StrategyTypeEnum;

import java.lang.annotation.*;

/**
 * @Author: smart lihao
 * @Date: 2019/6/12 15:36
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface StrategyTypeAnnotation {

    StrategyTypeEnum StrageType();

}
