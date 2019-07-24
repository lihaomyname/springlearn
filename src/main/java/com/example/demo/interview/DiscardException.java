package com.example.demo.interview;

/**
 * @Author: smart lihao
 * @Date: 2019/7/10 12:00
 */
public class DiscardException extends RuntimeException {
    private static final long serialVersionUID = 8827362380544575914L;

    DiscardException(String message) {
        super(message);
    }
}
