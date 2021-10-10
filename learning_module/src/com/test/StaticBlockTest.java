package com.test;


import com.learn.StaticBlock;
import org.junit.Test;

public class StaticBlockTest {

    @Test
    public void testStaticBlock() {

        StaticBlock sb = new StaticBlock();

        sb.method1();
        sb.method2();

        System.out.println("----------");

        StaticBlock sb2 = new StaticBlock();

        System.out.println("结论 -> " + "\n" +
                "- 当初始化一个类的时候, 即构造一个类的对象时. 执行的顺序是下面这样的" + "\n" +
                "- 首先执行static{}, 静态代码块. 并且 static{} 代码块仅仅执行一次" + "\n" +
                "- 然后紧接着执行 构造代码块, 即被花括号{} 包起来的代码" + "\n" +
                "- 然后执行该类的 构造方法" + "\n" +
                "- 最后再执行相应代码");


    }
}
