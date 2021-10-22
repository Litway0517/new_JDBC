package com.atguigu.java2.crud;


import com.atguigu.java1.util.JDBCUtils;
import com.atguigu.java2.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

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


    /*
        使用MapHandler存储查询到的 一条 数据
            这时返回的就是一个集合对象, 这个集合中有键值对

        map中的key为表的字段名, map中的value为表的一条数据的数据值.
     */
    @Test
    public void testQuery3() {
        Connection conn = null;

        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2. 提供一条带有占位符的查询语句
            String sql = "SELECT id,name,email,birth FROM customers where id = ?";

            // 3. 创建QueryRunner实例
            QueryRunner runner = new QueryRunner();

            // 4. 通过QueryRunner的实例, 调用其query()方法, 查询. 会返回一个结果集(这个结果就是java对象了)
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> map = runner.query(conn, sql, mapHandler, 1);
            System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.close(conn);
        }

    }

    /*
        使用MapListHandler存储查询到的 多条 数据
            这时返回的就是一个大集合, 实际上是一个list, 这个list的每个元素是一个一个的小集合,
            集合中有键值对. 就和上面一样了.
     */
    @Test
    public void testQuery4() {
        Connection conn = null;

        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2. 提供一条带有占位符的查询语句
            String sql = "SELECT id,name,email,birth FROM customers where id > ?";

            // 3. 创建QueryRunner实例
            QueryRunner runner = new QueryRunner();

            // 4. 通过QueryRunner的实例, 调用其query()方法, 查询. 会返回一个结果集(这个结果就是java对象了)
            MapListHandler mapList = new MapListHandler();
            // 查询到的是一个List集合, List集合中每一个元素是Map对象. 而Map对象就是一个小集合, Map里又有键值对
            List<Map<String, Object>> map = runner.query(conn, sql, mapList, 1);

            map.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.close(conn);
        }

    }

    /*
        查询表中的特殊数据, 比如 count(*)计数, max(xx), min(xx), avg等这几个组函数时, 使用的ScalarHandler这个对象接受结果
     */
    @Test
    public void testScalar5() {
        Connection conn = null;

        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2. 提供一条带有占位符的查询语句
            String sql = "SELECT count(*) from customers";

            // 3. 创建QueryRunner实例
            QueryRunner runner = new QueryRunner();

            // 4. 通过QueryRunner的实例, 调用其query()方法, 查询. 会返回一个结果集(这个结果就是java对象了)
            ScalarHandler scalar = new ScalarHandler();
            Object count = runner.query(conn, sql, scalar);

            System.out.println("信息计数共有 -> " + count + "条");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.close(conn);
        }


    }

    /*
        max组函数
        查询出生年月最大的
     */
    @Test
    public void testScalar6() {
        Connection conn = null;

        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2. 提供一条带有占位符的查询语句
            String sql = "SELECT max(birth) from customers";

            // 3. 创建QueryRunner实例
            QueryRunner runner = new QueryRunner();

            // 4. 通过QueryRunner的实例, 调用其query()方法, 查询. 会返回一个结果集(这个结果就是java对象了)
            ScalarHandler scalar = new ScalarHandler();
            Date birth = (Date) runner.query(conn, sql, scalar);

            System.out.println("最大的出生日期是 -> " + birth);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.close(conn);
        }


    }

}




