package com.atguigu.java3.test;


import com.atguigu.java1.util.JDBCUtils;
import com.atguigu.java3.CustomerDAOImpl;
import com.atguigu.java3.bean.Customer;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 客户DAOImpl测试
 *
 * @author DELL
 * @date 2021/10/13
 */
public class CustomerDAOImplTest {

//    private CustomerDAOImpl customerDAOImpl;
//    private Connection conn = JDBCUtils.getConnection();
    /*
        上面这两行代码, 放外面不行, 原因不清楚, Debug一下就发现了, 都是null
     */

    public CustomerDAOImplTest() throws Exception {
    }


    @Test
    public void customerDAOImplAddCustomer() {
        Connection conn = null;
        try {
            CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
            conn = JDBCUtils.getConnection();
            Customer customer = new Customer(0, "Tom", "tom@126.com", new Date(13131345335131L));
            int count = customerDAOImpl.addCustomer(conn, customer);
            System.out.println("添加了" + count + "条数据. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

    }

    @Test
    public void testCustomerDAOImplDeleteCustomer() {
        Connection conn = null;
        try {
            CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
            conn = JDBCUtils.getConnection();
            int count = customerDAOImpl.deleteCustomer(conn, 24);
            System.out.println("删除了" + count + "条数据. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
    }



    @Test
    public void testCustomerDAOImplGetAllCustomer() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
            List<Customer> allCustomers = customerDAOImpl.getAllCustomers(conn);
            allCustomers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

    }


    @Test
    public void testCustomerDAOImplUpdateCustomer() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
            int count = customerDAOImpl.updateCustomer(conn,
                    new Customer(23, "Jury", "jury@139.com", new Date(1654135643L)));

            System.out.println("更新了" + count + "条数据. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

    }






}
