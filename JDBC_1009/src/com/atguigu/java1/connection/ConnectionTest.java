package com.atguigu.java1.connection;


import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接测试
 *
 * @author DELL
 * @date 2021/10/09
 */

public class ConnectionTest {

    @Test
    public void testConnection1() throws SQLException {


        // 提供mysql中的driver接口类实现
        Driver driver = new com.mysql.jdbc.Driver();


        // 注册驱动
        DriverManager.registerDriver(driver);

        // 连接基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

        // 断言
        Assert.assertNotNull(conn);
    }





}
