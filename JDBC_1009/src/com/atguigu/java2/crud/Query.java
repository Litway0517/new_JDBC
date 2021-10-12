package com.atguigu.java2.crud;


import com.atguigu.java1.util.JDBCUtils;
import com.atguigu.java2.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * 查询
 *
 * @author DELL
 * @date 2021/10/12
 */
public class Query {

    /*
        测试数据表的查询操作
            这时有数据返回
     */

    /*
        BeanHandler -> 是查询数据库中的一条记录, 将结果返回为一个BeanHandler对象
     */
    @Test
    public void testQuery1() {
        Connection conn = null;


        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2. 提供一条带有占位符的查询语句
            String sql = "SELECT id,name,email,birth FROM customers where id = ?";

            // 3. 创建QueryRunner实例
            QueryRunner runner = new QueryRunner();

            // 4. 通过QueryRunner的实例, 调用其query()方法, 查询. 会返回一个结果集(这个结果就是java对象了)
            // 写成这样也行
            ResultSetHandler<List<Customer>> beanHandle = new BeanListHandler<Customer>(Customer.class);
            BeanHandler<Customer> beanHandler = new BeanHandler<Customer>(Customer.class);

            Customer customer = runner.query(conn, sql, beanHandler, 1);


            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.close(conn);
        }

    }


    /*
        BeanListHandler -> 查询, 对应表中的多条数据. 以以对象构成集合的方式返回
     */

    @Test
    public void testQuery2() {
        Connection conn = null;

        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2. 提供一条带有占位符的查询语句
            String sql = "SELECT id,name,email,birth FROM customers where id > ?";

            // 3. 创建QueryRunner实例
            QueryRunner runner = new QueryRunner();

            // 4. 通过QueryRunner的实例, 调用其query()方法, 查询. 会返回一个结果集(这个结果就是java对象了)
            BeanListHandler<Customer> beanHandler = new BeanListHandler<Customer>(Customer.class);
            List<Customer> list = runner.query(conn, sql, beanHandler, 1);

            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.close(conn);
        }

    }
}




