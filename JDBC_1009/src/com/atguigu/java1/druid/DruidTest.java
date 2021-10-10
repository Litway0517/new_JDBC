package com.atguigu.java1.druid;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 德鲁伊的测试
 *
 * @author DELL
 * @date 2021/10/10
 */
public class DruidTest {

    /*
        使用数据库连接池的好处
            - 更方便地获取连接, 效率高
            - 资源可以更好地利用
            - 便于进行必要的管理

     */


    /*
        有哪些数据连接池技术?
            - DBCP -> 速度快, 但是不稳定, 有BUG
            - C3P0 -> 速度相对较慢, 比较稳定
            - druid -> 肩具二者的特性

     */

    @Test
    public void testDruid1() throws SQLException {

        /*
            使用druid获取连接的第一种方式
         */

        // 创建数据库连接池子
        DruidDataSource source = new DruidDataSource();

        // 设置4个连接的基本信息
        source.setUsername("root");
        source.setPassword("root");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setDriverClassName("com.mysql.jdbc.Driver");

        // 设置连接池中最大的连接数
        source.setMaxActive(10);
        // 设置初始化的时候, 池子中给出的连接数, 当不够了之后, 再去申请
        source.setInitialSize(5);


        // 获取一个连接池中的一个连接
        DruidPooledConnection conn = source.getConnection();
        System.out.println(conn);

        // 断言
        Assert.assertNotNull(conn);
    }


}











