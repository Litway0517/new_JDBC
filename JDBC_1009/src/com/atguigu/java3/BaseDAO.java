package com.atguigu.java3;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO {

    // 定义通用的增删改操作
    private QueryRunner runner = new QueryRunner();

    public int Update(Connection conn, String sql, Object ... objs) throws SQLException {
        return runner.update(conn, sql, objs);

    }


    // 查询操作 -> 查询表中的一条记录
    public <T> T getInstance(Connection connection, String sql, Class<T> clazz, Object ... objs)
            throws SQLException
    {
        BeanHandler<T> handler = new BeanHandler<T>(clazz);
        return runner.query(connection, sql, handler, objs);

    }

    // 查询操作 -> 查询表中的多条记录
    public <T> List<T> getForList(Connection connection, String sql, Class<T> clazz, Object ... objs)
            throws SQLException
    {
        BeanListHandler<T> handler = new BeanListHandler<T>(clazz);
        return runner.query(connection, sql, handler, objs);
    }

    // 查询特殊值 -> 返回的可能是多条特殊值
    /*
        这个直接就用Object返回吧, 即使是写了泛型T, 实际上还是会有检查机制
     */
    public Object getValue(Connection connection, String sql, Object... objs) throws SQLException {


        ScalarHandler handler = new ScalarHandler();
        return runner.query(connection, sql, handler, objs);
    }




}
