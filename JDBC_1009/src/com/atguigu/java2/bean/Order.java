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
    private int order_id;

    /**
     * 订单名称
     */
    private String order_name;

    /**
     * 订单日期
     */
    private Date order_date;

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
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_date = order_date;
    }

    /**
     * 得到订单id
     *
     * @return int
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * 设置订单id
     *
     * @param order_id 订单id
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * 得到订单的名字
     *
     * @return {@code String}
     */
    public String getOrder_name() {
        return order_name;
    }

    /**
     * 设置订单名称
     *
     * @param order_name 订单名称
     */
    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    /**
     * 得到订单日期
     *
     * @return {@code Date}
     */
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * 设置订单日期
     *
     * @param order_date 订单日期
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    /**
     * 字符串
     *
     * @return {@code String}
     */
    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_name='" + order_name + '\'' +
                ", order_date=" + order_date +
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

        if (order_id != order.order_id) return false;
        if (order_name != null ? !order_name.equals(order.order_name) : order.order_name != null) return false;
        return order_date != null ? order_date.equals(order.order_date) : order.order_date == null;
    }

    /**
     * 散列码
     *
     * @return int
     */
    @Override
    public int hashCode() {
        int result = order_id;
        result = 31 * result + (order_name != null ? order_name.hashCode() : 0);
        result = 31 * result + (order_date != null ? order_date.hashCode() : 0);
        return result;
    }
}
