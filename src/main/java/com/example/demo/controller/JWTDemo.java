package com.example.demo.controller;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: smart lihao
 * @Date: 2019/5/29 14:06
 */
public class  JWTDemo {

    //加密的
    private static final String SECRET_KEY = "123456789";

    public static void main(String... args) throws InterruptedException {


        //jwt
        //设置3秒后过期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = System.currentTimeMillis() + 30 * 60 * 1000;
        String jwt = buildJwt(new Date(time));
        System.out.println("jwt = " + jwt);
        // 验证token是否可用
        boolean isOk = isJwtValid(jwt);
        System.out.println(isOk);
    }


    public static String buildJwt(Date exp) {

        // SECRET_KEY是加密算法对应的密钥，这里使用额是HS256加密算法//
        //expTime是过期时间
        //该方法是在JWT中加入值为vaule的key字段
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY).
                setExpiration(exp).claim("name", "wangtingjun").
                claim("age", "18").claim("key", "vaule").compact();
        return jwt;
    }


    public static boolean isJwtValid(String jwt) {
        try {
            //解析JWT字符串中的数据，并进行最基础的验证
            //SECRET_KEY是加密算法对应的密钥，jjwt可以自动判断机密算法

            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody();
            System.out.println(claims);
            String vaule = claims.get("key", String.class);
            //获取自定义字段key
            // 判断自定义字段是否正确
            if ("vaule".equals(vaule)) {
                return true;
            } else {
                return false;
            }
        }
        //在解析JWT字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该JWT字符串是伪造的
        // 在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
        catch (SignatureException | ExpiredJwtException e) {
            return false;
        }
    }
}
