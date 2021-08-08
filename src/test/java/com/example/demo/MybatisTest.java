package com.example.demo;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
public class MybatisTest {

    @Autowired
    private SqlSession sqlSession;
    @Test
    public void testGetConnection() {
        Connection conn=sqlSession.getConnection();
        System.out.println("connection="+conn);
    }
}
