package com.fastcampus.ch4.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * packageName :  com.fastcampus.ch4.domain
 * fileName : PageHandlerTest
 * author :  82108
 * date : 2023-03-15
 * description :
 */
public class PageHandlerTest {

    @Test
    public void test() {
        PageHandler ph = new PageHandler(250, 1);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() == 1);
        assertTrue(ph.getEndPage() == 10);
    }

    @Test
    public void test2() {
        PageHandler ph = new PageHandler(250, 11);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() == 11);
        assertTrue(ph.getEndPage() == 20);

    }

    @Test
    public void test3() {
        PageHandler ph = new PageHandler(255, 22);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() == 21);
        assertTrue(ph.getEndPage() == 26);

    }

    @Test
    public void test4() {
        PageHandler ph = new PageHandler(255, 10);
        ph.print();
        System.out.println("ph = " + ph);
//        assertTrue(ph.getBeginPage() == 21);
//        assertTrue(ph.getEndPage() == 26);

    }

}