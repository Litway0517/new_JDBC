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
    JDBC工具类, 可以直接使用这里面的方法获取连接, 而不需要再重写代码
 */
public class JDBCUtils {

    /*
        因为下面的静态方法, static初始化方法, 需要用到, dataSource这个变量, 而静态方法只能调用静态的对象.
        因此, dataSource需要用static修饰

     */
    // 定义一个类的静态变量
    private static DataSource dataSource;

    /*
        static代码块, 是当类加载完成的时候, 仅仅执行一次, 这样就只会有一个dataSource, 也就是只有一个数据池
        static代码块执行的目的就是为了创建一个数据池, 并赋值给外面的静态dataSource变量
     */
    static {
        try {
            // 创建prop对象
            Properties prop = new Properties();
            // 读取配置文件
            InputStream fr = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            prop.load(fr);

            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        每次调用这个方法, 仅仅是从数据库连接池中拿一个连接使用.
        而不是像之前的方法, 每次都创建一个数据池, 再从数据池中拿一个连接(这种方式更慢)
     */
    public static Connection getConnection() throws Exception {
        // 获取一个连接
        return dataSource.getConnection();
    }




}





