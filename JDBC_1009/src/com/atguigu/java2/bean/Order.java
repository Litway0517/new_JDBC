package com.atguigu.java2.bean;


import java.sql.Date;


/**
 * 订单
 *
 * @author DELL
 * @date 2021/10/12
 */
public class Order {

    /**
     * 订单id
     */
    private int orderId;

    /**
     * 订单名称
     */
    private String orderName;

    /**
     * 订单日期
     */
    private Date orderDate;

    /**
     * 订单
     */
    public Order() {
    }

    /**
     * 订单
     *
     * @param order_id   订单id
     * @param order_name 订单名称
     * @param order_date 订单日期
     */
    public Order(int order_id, String order_name, Date order_date) {
        this.orderId = order_id;
        this.orderName = order_name;
        this.orderDate = order_date;
    }

    /**
     * 得到订单id
     *
     * @return int
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * 得到订单的名字
     *
     * @return {@code String}
     */
    public String getOrderName() {
        return orderName;
    }

    /**
     * 设置订单名称
     *
     * @param orderName 订单名称
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    /**
     * 得到订单日期
     *
     * @return {@code Date}
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 设置订单日期
     *
     * @param orderDate 订单日期
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 字符串
     *
     * @return {@code String}
     */
    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + orderId +
                ", order_name='" + orderName + '\'' +
                ", order_date=" + orderDate +
                '}';
    }

    /**
     * =
     *
     * @param o o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;
        return orderDate != null ? orderDate.equals(order.orderDate) : order.orderDate == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }
}
