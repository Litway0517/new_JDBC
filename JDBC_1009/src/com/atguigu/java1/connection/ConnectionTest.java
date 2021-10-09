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


    // 方式二 -> 面向接口编程, 使用反射实现Driver的实例化. 这样第三方的代码就只有一个字符串了
    @Test
    public void testConnection2() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SQLException {

        // 提供mysql中Driver接口的实现类对象
        String className = "com.mysql.jdbc.Driver";
        Class<?> clazz = Class.forName(className);
        Driver driver = (Driver) clazz.newInstance();

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


    // 方式三 -> 省略注册的过程
    @Test
    public void testConnection3() throws SQLException, ClassNotFoundException {

        //1. 获取连接的4个基本信息
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";  //test:表示具体的数据库名
        String user = "root";
        String password = "root";


        //2. 加载驱动
        Class.forName(className);

        //注册驱动
//        DriverManager.registerDriver(driver);
        /*
        * 之所以不再代码中显式使用DriverManager的注册功能，是因为在msyql的Driver类的源码中发现：
        *  static {
                try {
                    java.sql.DriverManager.registerDriver(new Driver());
                } catch (SQLException E) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
        *
        * */
        //3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }



}
