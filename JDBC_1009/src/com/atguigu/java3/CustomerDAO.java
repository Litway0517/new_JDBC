package com.atguigu.java3;

import com.atguigu.java3.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 客户刀
 *
 * @author DELL
 * @date 2021/10/13
 */
public interface CustomerDAO {


    /**
     * 添加客户
     * 想数据表中添加一条记录
     *
     * @param connection 连接
     * @param customer   客户
     */
    public abstract void addCustomer(Connection connection, Customer customer);

    /**
     * 删除数据
     * 根据指定的id, 删除表中的一条记录
     *
     * @param connection 指定的具体连接
     * @param customer 传入新的customer, 后面将会根据传入的customer的id, 直接覆盖数据
     */
    public abstract void deleteCustomer(Connection connection, Customer customer);

    /**
     * 更新数据
     *
     *
     * @param connection 具体指定的连接
     * @param customer 一条记录
     */
    public abstract void updateCustomer(Connection connection, Customer customer);

    /**
     * 根据知名的id, 获取一条记录
     * @param connection 具体指定的连接
     * @param id 记录的标号
     * @return 返回要查询的结果
     */
    public abstract Customer getCustomer(Connection connection, int id);


    /**
     * 查询所有记录
     * 查询数据库中该表的所有记录, 返回一个列表, 列表的元素为查询到的结果
     *
     * @param connection 具体指定的连接
     * @return
     */
    public abstract List<Customer> getAllCustomers(Connection connection);

    /**
     * 查询表中的记录数(是一个具体的数据)
     *
     * @param connection 具体指定的连接
     * @return
     */
    public abstract long getCount(Connection connection);


    /**
     * 获取表中的最大生日字段
     *
     * @param connection 具体指定的连接
     * @return
     */
    public abstract Date getMaxBirth(Connection connection);



}



