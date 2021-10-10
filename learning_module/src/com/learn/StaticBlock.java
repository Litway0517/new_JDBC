package com.learn;



/**
 * 静态块
 *
 * @author DELL
 * @date 2021/10/10
 */
public class StaticBlock {

    public void method1() {
        System.out.println("method1()方法被执行");

    }

    public void method2() {
        System.out.println("method2()方法被执行");
    }

    /*
        这个是 -> 构造代码块
        这类代码位于class() {}下面, 但是不存在于其他 type method() {} 的代码区域
     */
    {
        System.out.println("I'm a constructor code block. 构造代码块被执行" );
    }



    // 这个是 -> 构造函数代码块
    public StaticBlock() {
        System.out.println("I'm a constructor method code block. 构造方法被执行");
    }


    /*
        static代码块
        这里的静态代码, 只执行一次, 可以通过Class.forName("classPath")方式唤醒static代码块, 但是也只执行一次
     */
    static {
        System.out.println("I'm a static code block. 静态代码块被执行");
    }

}





