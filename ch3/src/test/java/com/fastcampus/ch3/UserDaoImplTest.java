package com.fastcampus.ch3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * packageName :  com.fastcampus.ch3
 * fileName : UserDaoImplTest
 * author :  82108
 * date : 2023-03-14
 * description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    public void deleteUser() {
    }

    @Test
    public void selectUser() {
    }

    @Test
    public void insertUser() {
    }

    @Test
    public void updateUser() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2021, 1, 1);

        userDao.deleteAll();
        User user = new User("asdf4", "1234", "abc", "aaa@aaa.com", new Date(cal.getTimeInMillis()), "fb", new Date(cal.getTimeInMillis()));
        int rowCnt = userDao.insertUser(user);
        assertTrue(rowCnt == 1);

        user.setPwd("4321");
        user.setEmail("bbb@bbb.com");
        rowCnt = userDao.updateUser(user);
        assertTrue(rowCnt == 1);

        User user2 = userDao.selectUser(user.getId());

        System.out.println("------------------------------------------");
        System.out.println("user = " + user);
        System.out.println("user2 = " + user2);
        System.out.println("------------------------------------------");

        assertTrue(user.equals(user2));

    }

    @Test
    public void deleteAll() {
    }
}