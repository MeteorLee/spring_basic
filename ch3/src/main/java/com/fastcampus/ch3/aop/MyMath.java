package com.fastcampus.ch3.aop;

import org.springframework.stereotype.Component;

/**
 * packageName :  com.fastcampus.ch3.aop
 * fileName : MyMath
 * author :  82108
 * date : 2023-03-14
 * description :
 */
@Component
public class MyMath {
    public int add (int a, int b) {
        int result = a + b;
        return result;
    }
    public int add (int a, int b, int c) {
        int result = a + b + c;
        return result;
    }
    public int subtract (int a, int b) {
        int result = a - b;
        return result;
    }
    public int multiply (int a, int b) {
        int result = a * b;
        return result;
    }

}
