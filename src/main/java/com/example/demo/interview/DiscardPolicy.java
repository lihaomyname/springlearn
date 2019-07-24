package com.example.demo.interview;

/**
 * @Author: smart lihao
 * @Date: 2019/7/10 11:58
 */
public interface DiscardPolicy {
    void discard() throws DiscardException;
}
