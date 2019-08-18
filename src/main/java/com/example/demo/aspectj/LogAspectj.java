package com.example.demo.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: smart lihao
 * @Date: 2019/8/1 18:37
 */
@Component
@Slf4j
@Aspect
public class LogAspectj {


    @Pointcut("@annotation(com.example.demo.annotation.LogAnnotation)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void Before(JoinPoint point) {
        System.out.println("---------"+point);

    }

}
