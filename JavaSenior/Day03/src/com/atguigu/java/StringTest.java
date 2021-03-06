package com.atguigu.java;

import org.junit.Test;

/**
 * 相同的内容会调用同一个值的地址，重新赋值会创建新的值并赋予新值的地址，拼接内容会使用新内存创建新值
 *
 * @author chenglongsheng
 * @create 2021-04-16 8:54
 */
public class StringTest {

    /*
    结论：
    1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
    2.只要其中有一个是变量，结果就在堆中
    3.如果拼接结果调用intern()，返回值就在常量池中
     */
    @Test
    public void test3() {
        String s1 = "java";
        String s2 = "EE";

        String s3 = "javaEE";//字面量连接是同一个
        String s4 = "java" + "EE";//两个字面量连接
        String s5 = s1 + "EE";
        String s6 = "java" + s2;
        String s7 = s1 + s2;

        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s3==s6);
        System.out.println(s3==s7);
        System.out.println(s5==s6);
        System.out.println(s5==s7);
        System.out.println(s5==s7);

        String s8 = s5.intern();
        System.out.println(s3 == s8);
    }

    /*
    String的实例化方式：
    方式一:通过字面量定义的方式
    方式二：通过new + 构造器的方式

    面试题:String s = new String("abc");方式创建对象，在内存中创建几个对象?

        两个，一个是堆空间中new结构，另一个是char[]对应的的常量池中的数据："abc"
     */
    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "javaEE";

        // 通过new+ 构造器的方式：此时的s3和s4保存的地址值，是在数据的堆空间
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);

        System.out.println("*************");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);

        p1.name = "Jerry";
        System.out.println(p2.name);
    }

    /*
    1.String声明为final，不可被继承
    2.String实现了Serializable接口：表示字符串是支持序列化的
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用于储存字符串数据
    4.String：代表不可变的字符序列。简称：不可变性。
        体现；1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有value进行赋值
             2.当对现有字符串进行连续操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
             3.当调用String的replace()修改指定字符或者字符串时，也需要重新指定内存区域
    5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池时不会储存相同内容的字符串的。
     */
    @Test
    public void test1() {

        String s1 = "abc";
        String s2 = "abc";

        String s3 = "a";
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("*************");
        String s4 = "abc";
        s4 += "def";
        System.out.println(s4);

        System.out.println("*************");

        String s5 = "abc";
        String s6 = s5.replace('a', 'b');
        System.out.println(s6);
    }
}
