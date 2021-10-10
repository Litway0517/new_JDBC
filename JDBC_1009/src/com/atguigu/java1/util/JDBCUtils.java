package com.atguigu.java1.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * jdbcutils
 *
 * @author DELL
 * @date 2021/10/10
 */


/*
    JDBC工具类
 */
public class JDBCUtils {

    public static Connection getConnection() throws Exception {
        // 创建prop对象
        Properties prop = new Properties();

        // 读取配置文件
        InputStream fr = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        prop.load(fr);

        // 通过DruidDataSourceFactory创建连接池
        DataSource source = DruidDataSourceFactory.createDataSource(prop);

        // 获取一个连接
        return source.getConnection();
    }

}





