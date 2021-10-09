package com.atguigu.java1.connection;


import org.junit.Assert;
import org.junit.Test;

import javax.annotation.processing.Filer;
import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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


    /*
        方式四 -> 将配置文件的信息, 与代码解耦. 数据库的基本信息配置在文件中, 不放在class字节码文件中.

        使用文件配置的方式的好处?
            - 实现了数据和代码的分离, 解耦.
            - 编写好的java文件, 部署到服务器上时, 需要打包. 如果java代码经过修改了, 就需要重新打包.
                使用配置文件的方式, 如果配置信息修改, 并没有导致代码的修改, 所以不需要重新打包.
                配置文件的更改, 只需要重新替换一下.

     */
    @Test
    public void testConnection4() throws ClassNotFoundException, SQLException, IOException {

        // 读取配置文件
        Properties prop = new Properties();
        InputStream fr = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        prop.load(fr);


        String className = prop.getProperty("className");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        // 注册驱动
        Class.forName(className);

        // 创建链接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

        // 测试结果
        Assert.assertNotNull(conn);

    }



}
