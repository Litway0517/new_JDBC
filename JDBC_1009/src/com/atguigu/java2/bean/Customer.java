package com.atguigu.java2.bean;


import java.sql.Date;

/**
 * 客户
 * ORM(object relational mapping -> 对象关系映射)编程思想
 *      简单地说, 就是把一个对象A映射成另一个对象B, 但是他它们本质是同一个对象, 只是在不同的环境下不同的表达或展现方式
 *
 * 对应关系 ->
 *      数据库中的一个表    与   Java中的一个类对应
 *      表中的一条记录      与   类中的一个对象对应
 *      表中的一列(或字段)  与    类中的一个属性对应
 * @author DELL
 * @date 2021/10/12
 */
public class Customer {

    /**
     * id编号
     */
    private int id;

    /**
     * 名字
     */
    private String name;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 出生
     */
    private Date birth;

    // private Blob photo;

    public Customer() {
    }

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
