package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * packageName :  com.fastcampus.ch3
 * fileName : TxService
 * author :  82108
 * date : 2023-03-14
 * description :
 */
@Service
public class TxService {
    @Autowired
    A1Dao a1Dao;
    @Autowired
    B1Dao b1Dao;

    @Autowired
    DataSource ds;

//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insertA1WithTx() throws Exception {
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
        txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = tm.getTransaction(txd);

        try {
            a1Dao.insert(1, 100);
            insertB1WithTx();
            a1Dao.insert(2, 200);
            tm.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback(status);
        } finally {

        }


    }

//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insertB1WithTx() throws Exception {
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
        txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = tm.getTransaction(txd);

        try {
            b1Dao.insert(1, 100);
            b1Dao.insert(1, 200);
            tm.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback(status);
        } finally {

        }
    }


    public void insertA1WithoutTx() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(1, 200);
    }

    @Transactional(rollbackFor = Exception.class)
//    @Transactional // RuntimeException, Error 만 잡음
    public void insertA1WithTxFail() throws Exception {
        a1Dao.insert(1, 100);
//        throw new RuntimeException();
//        throw new Exception();
        a1Dao.insert(1, 200);
    }

    @Transactional
    public void insertA1WithTxSuccess() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(2, 200);
    }
}
