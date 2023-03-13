package com.fastcampus.ch3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * packageName :  com.fastcampus.ch3
 * fileName : DBConnectionTest2Test
 * author :  82108
 * date : 2023-03-14
 * description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class DBConnectionTest2Test {

    @Autowired
    DataSource ds;

    @Test
    public void insertUserTest() throws Exception {
        User user = new User("asdf4", "1234", "abc", "aaa@aaa.com", new Date(), "fb", new Date());
        deleteAll();
        int rowCnt = insertUser(user);

        assertTrue(rowCnt == 1);
    }

    @Test
    public void selectUserTest() throws Exception {
        deleteAll();
        User user = new User("asdf4", "1234", "abc", "aaa@aaa.com", new Date(), "fb", new Date());
        int rowCnt = insertUser(user);
        User user2 = selectUser("asdf4");

        assertTrue(user2.getId().equals("asdf4"));
    }

    @Test
    public void deleteUserTest() throws Exception {
        deleteAll();
        int rowCnt = deleteUser("asdf");

        assertTrue(rowCnt == 0);

        User user = new User("asdf4", "1234", "abc", "aaa@aaa.com", new Date(), "fb", new Date());
        rowCnt = insertUser(user);
        assertTrue(rowCnt == 1);

        rowCnt = deleteUser(user.getId());
        assertTrue(rowCnt == 1);

        assertTrue(selectUser(user.getId()) == null);


    }

    @Test
    public void updateUserTest() throws Exception {
        deleteAll();
        User user = new User("asdf4", "1234", "abc", "aaa@aaa.com", new Date(), "fb", new Date());

        int rowCnt = insertUser(user);
        assertEquals(1, rowCnt);

        User user2 = new User("asdf4", "12345", "abcd", "bbb@bbb.com", new Date(), "fb", new Date());
        rowCnt = updateUser(user2);

        assertEquals(1, rowCnt);

    }

    // 매개변수로 받은 사용자 정보로 user_info테이블을 update하는 메서드
    public int updateUser(User user) throws Exception {

        Connection conn = ds.getConnection();

        String sql = "update user_info " +
                "set pwd = ?, name = ?, email = ?, birth = ?, sns = ? " +
                "where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getPwd());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getEmail());
        pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
        pstmt.setString(5, user.getSns());
        pstmt.setString(6, user.getId());

        return pstmt.executeUpdate();

    }

    public int deleteUser(String id) throws Exception {
        Connection conn = ds.getConnection();

        String sql = "delete from user_info where id = ?";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();

    }

    public User selectUser(String id) throws Exception{

        Connection conn = ds.getConnection();

        String sql = "select * from user_info where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setId(rs.getString(1));
            user.setPwd(rs.getString(2));
            user.setName(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setBirth(new Date(rs.getDate(5).getTime()));
            user.setBirth(rs.getTime(5));
            user.setSns(rs.getString(6));
            user.setReg_date(new Date(rs.getTimestamp(7).getTime()));

            return user;
        }

        return null;
    }

    private void deleteAll() throws Exception{

        Connection conn = ds.getConnection();

        String sql = "delete from user_info";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate(); // insert, delete, update
    }

    // 사용자 정보를 user_info 테이블에 저장하는 메서드
    public int insertUser(User user) throws Exception {
        Connection conn = ds.getConnection();

//        insert into user_info
//        values ('asdf','1234','smith','aaa@aaa.com','2021-01-01','facebook',NOW());

        String sql = "insert into user_info values (?, ?, ?, ?, ?, ?, NOW())";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getPwd());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getEmail());
        pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
        pstmt.setString(6, user.getSns());

        int rowCnt = pstmt.executeUpdate(); // insert, delete, update

        return rowCnt;
    }

    @Test
    public void springJdbcConnectionTest() throws Exception {
//        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//        DataSource ds = ac.getBean(DataSource.class);

        Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.

        System.out.println("conn = " + conn);
        assertNotNull(conn); // 괄호 안의 조건식이 true면 테스트 성공, 아니면 실패

    }


}