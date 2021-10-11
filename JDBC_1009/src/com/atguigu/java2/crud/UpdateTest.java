package com.atguigu.java2.crud;


import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;

/**
 * 更新测试
 *
 * @author DELL
 * @date 2021/10/11
 */
public class UpdateTest {

    /*
        测试向数据表中添加, 删除, 修改数据

     */
    // 向数据表中添加一条记录
    @Test
    public void testUpdate1(){
        Connection conn = null;

        try {
            // 1- 获取连接(使用刚才封装好的, JDBCUtils工具类, 直接获取一个连接)
            conn = JDBCUtils.getConnection();

            // 2- 提供一个添加操作的sql
            String sql = "INSERT INTO customers(name,email,birth) VALUES('王海','tom@126.com','2021-10-05')";

            // 3- 使用其他第三方封装好的QueryRunner, 调用update()方法, 实现数据的插入
            QueryRunner runner = new QueryRunner();
            int count = runner.update(conn, sql);
            System.out.println("添加了" + count + "行数据. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

    }

    /*
        使用占位符的sql, 下面的更新也是这样的

        update(Connection conn, String sql, Object... params)
          Execute an SQL INSERT, UPDATE, or DELETE query.

          这个函数, 是在sql中有可变的参数, 等待调用update函数时再传入具体参数 -> 较多的开发情况会用到
     */
    @Test
    public void testUpdate2(){
        Connection conn = null;

        try {
            // 1- 获取连接(使用刚才封装好的, JDBCUtils工具类, 直接获取一个连接)
            conn = JDBCUtils.getConnection();

            // 2- 提供一个添加操作的sql -> 问号?是占位符
            String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";

            // 3- 使用其他第三方封装好的QueryRunner, 调用update()方法, 实现数据的插入
            QueryRunner runner = new QueryRunner();
            // 用"王亮", "wangl@163.com", new Date(151335133L), 这三个参数去代替上面的sql语句中的 占位符(?被叫做占位符)
            int count = runner.update(conn, sql, "王亮", "wangl@163.com", new Date(151335133L));
            System.out.println("添加了" + count + "行数据. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
    }

    /*
        使用这种占位符的好处
            - 如果需要存入百万条数据, 如果使用第一种方式, 那么就会有百万条sql语句, 那么sql引擎每一次都需要校验一次.
                因此, 花费的时间非常之大. 但是写成第二种占位符的方式, 然后再把sql的格式的校验缓存起来, 这样只需要装配sql的
                后面的变化的参数部分, 时间会快很多.
            - 如果需要向数据库上传图片数据, 实际上需要传入的是二进制数据, 一张图片的大小比字符串大很多, 不可能把二进制数据写在
                sql语句中, 那写不下的. 需要传入的是流变量才可以.

            第二种方式更便捷能是用
     */


    /*
        同样使用占位符, 演示一下删除操作
     */
    @Test
    public void testUpdate3() {
        Connection conn = null;

        try {
            // 1- 获取连接(使用刚才封装好的, JDBCUtils工具类, 直接获取一个连接)
            conn = JDBCUtils.getConnection();

            // 2- 提供一个添加操作的sql -> 问号?是占位符
            String sql = "DELETE FROM customers where id > ?";

            // 3- 使用其他第三方封装好的QueryRunner, 调用update()方法, 实现数据的插入
            QueryRunner runner = new QueryRunner();
            // 删除id大于19的记录, 不包括id = 19这条记录
            int count = runner.update(conn, sql, 19);
            System.out.println("删除了" + count + "行数据. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

    }


    /*
        更新数据update
        delete和update这两个SQL, 可能是批量操作好几条数据的, 但是insert一般只是针对一条数据做操作
     */
    @Test
    public void testUpdate4() {
        Connection conn = null;

        try {
            // 1- 获取连接(使用刚才封装好的, JDBCUtils工具类, 直接获取一个连接)
            conn = JDBCUtils.getConnection();

            // 2- 提供一个添加操作的sql -> 问号?是占位符
            String sql = "UPDATE customers set email = ? where id = ?";

            // 3- 使用其他第三方封装好的QueryRunner, 调用update()方法, 实现数据的插入
            QueryRunner runner = new QueryRunner();
            int count = runner.update(conn, sql, "tom@gmail.com", 19);
            System.out.println("更新了" + count + "行数据. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
    }
}




