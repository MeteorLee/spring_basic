package com.fastcampus.ch3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * packageName :  com.fastcampus.ch3
 * fileName : TxServiceTest
 * author :  82108
 * date : 2023-03-14
 * description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class TxServiceTest {
    @Autowired
    TxService txService;

    @Test
    public void insertA1WithoutTxTest() throws Exception {
//        txService.insertA1WithTxFail();
        txService.insertA1WithTx();

    }




}