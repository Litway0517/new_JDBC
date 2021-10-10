package com.atguigu.java1.test;


import com.atguigu.java1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilsTest {

    @Test
    public void testJDBCUtils() throws Exception {

        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }

}
