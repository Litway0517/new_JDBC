package com.atguigu.java2.crud1;

import com.atguigu.java1.util.JDBCUtils;
import com.atguigu.java2.bean.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;

public class Query {

    /*
        order -> 这张表的名字和数据库关键字一样, 所以需要加, 大写键盘数字键1 左面的那个字符, 我也不知道叫什么.
        虽然在sqlyog上面, 加上了之后能够执行, 但是在Java中又不行了, 原因是没有装配成功.
     */

    @Test
    public void testQuery1() throws Exception {
        // 获取链接
        Connection conn = JDBCUtils.getConnection();

        // 写出sql
        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";

        // 创建查询实例
        QueryRunner runner = new QueryRunner();

        // 创建BeanHandler实例, 用于接收结果
        BeanHandler<Order> beanResult = new BeanHandler<Order>(Order.class);
        Order query = runner.query(conn, sql, beanResult, 1);

        System.out.println(query);



    }

}






