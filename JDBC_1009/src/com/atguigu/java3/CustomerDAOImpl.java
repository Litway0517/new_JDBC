package com.atguigu.java3;


import com.atguigu.java3.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


/**
 * 客户DAO实现类
 *
 * @author DELL
 * @date 2021/10/13
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {


    /**
     * 添加客户
     * 想数据表中添加一条记录
     *
     * @param connection 连接
     * @param customer   客户
     */
    @Override
    public int addCustomer(Connection connection, Customer customer) throws SQLException {
        // sql语句
        String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
        return update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth());
    }

    /**
     * 删除数据
     * 根据指定的id, 删除表中的一条记录
     *
     * @param connection 指定的具体连接
     * @param id 传入需要删除记录的id字段值
     */
    @Override
    public int deleteCustomer(Connection connection, int id) throws SQLException {
        // sql语句
        String sql = "DELETE FROM customers WHERE id = ?";
        return update(connection, sql, id);
    }

    /**
     * 更新数据
     *
     * @param connection 具体指定的连接
     * @param customer   一条记录
     */
    @Override
    public int updateCustomer(Connection connection, Customer customer) throws SQLException {
        String sql = "UPDATE customers SET `name` = ?,email = ?,birth = ? WHERE id = ?";
        return update(connection, sql,
                customer.getName(), customer.getEmail(), customer.getBirth(), customer.getId());
    }

    /**
     * 根据知名的id, 获取一条记录
     *
     * @param connection 具体指定的连接
     * @param id         记录的标号
     * @return 返回要查询的结果
     */
    @Override
    public Customer getCustomer(Connection connection, int id) throws SQLException {
        String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
        return getInstance(connection, sql, Customer.class, id);
    }

    /**
     * 查询所有记录
     * 查询数据库中该表的所有记录, 返回一个列表, 列表的元素为查询到的结果
     *
     * @param connection 具体指定的连接
     * @return 返回数据库中该表的所有记录
     */
    @Override
    public List<Customer> getAllCustomers(Connection connection) throws SQLException {
        String sql = "SELECT id,name,email,birth FROM customers";
        return getForList(connection, sql, Customer.class);
    }

    /**
     * 查询表中的记录数(是一个具体的数据)
     *
     * @param connection 具体指定的连接
     * @return
     */
    @Override
    public long getCount(Connection connection) throws SQLException {
        String sql = "SELECT COUNT(*) FROM customers";
        return (long) getValue(connection, sql);
    }

    /**
     * 获取表中的最大生日字段
     *
     * @param connection 具体指定的连接
     * @return 返回数据库中该表的日期字段中最大的那个
     */
    @Override
    public Date getMaxBirth(Connection connection) throws SQLException {
        String sql = "SELECT MAX(birth) FROM customers";
        return (Date) getValue(connection, sql);
    }
}
