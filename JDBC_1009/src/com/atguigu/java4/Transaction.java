package com.atguigu.java4;


import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务
 *
 * 数据库事务 ->
 *      事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态
 *
 * DBMS对于事务的处理的态度 ->
 *      保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变
 * 这种执行方式。当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些
 * 修改就永久地保存下来；要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到
 * 最初状态。
 *
 *      比如下面的AA给BB转账的操作, 如果AA转出了100元, 必须要BB收到了才行. 之后整个事务算作完成, 并提交.
 *      如果说因为任何原因, AA的100元转账出去了, 但是最终确认BB未收到时, 那么就必须回滚事务, 执行失败.
 *
 * @author DELL
 * @date 2021/10/13
 */
public class Transaction {

    /*
        涉及的表 ->
            user_table
        场景 -> AA 给 BB  转账 100

        操作1 -> UPDATE user_table SET balance = balance - 100 WHERE user = 'AA';
        操作2 -> UPDATE user_table SET balance = balance - 100 WHERE user = 'BB';
     */

    @Test
    public void test1() {

        /*
            下面代码的执行过程 ->
                当执行完sql1的时候, 就会继续执行sout语句, 但是被除数是0, 显然是异常, 因此代码转入到
                catch (Exception e) {
                    e.printStackTrace();
                }
                最后执行 ->
                finally {
                    JDBCUtils.close(conn);
                }
                关闭了资源就表明, 会提交, 但是AA转账了100元, BB并没有收到啊? 钱没了!!

                看test2
         */

        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();


            // 操作1
            String sql1 = "UPDATE user_table SET balance = balance - 100 WHERE user = ?;";
            int aa = runner.update(conn, sql1, "AA");

            // 模拟异常出现
            System.out.println(10 / 0);


            // 操作2
            String sql2 = "UPDATE user_table SET balance = balance + 100 WHERE user = ?;";
            int bb = runner.update(conn, sql2, "BB");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }



    }



}
