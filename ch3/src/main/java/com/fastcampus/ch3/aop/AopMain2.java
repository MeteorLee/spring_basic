package com.fastcampus.ch3.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * packageName :  com.fastcampus.ch3.aop
 * fileName : AopMain2
 * author :  82108
 * date : 2023-03-14
 * description :
 */
public class AopMain2 {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context_aop.xml");

        MyMath myMath = (MyMath) ac.getBean("myMath");
//        System.out.println("myMath.add(3, 5) = " + myMath.add(3, 5));
//        System.out.println("myMath.multiply(3, 5) = " + myMath.multiply(3, 5));

        myMath.add(3, 5);
        myMath.add(3, 5, 6);
        System.out.println("myMath.multiply(3, 5) = " + myMath.multiply(3, 5));


    }
}
