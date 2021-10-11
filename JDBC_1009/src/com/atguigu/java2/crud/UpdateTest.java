package com.atguigu.java2.crud;


import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;

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


}




