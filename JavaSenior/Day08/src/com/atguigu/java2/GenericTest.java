package com.atguigu.java2;

import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *      类A是类B的父类，C<A> 和 C<B> 二者不具备子父类关系，二者是并列关系
 *
 * 2.通配符的使用
 *
 * @author chenglongsheng
 * @create 2021-05-18 16:48
 */
public class GenericTest {

    @Test
    public void test1() {
        Object obj = null;
        String str = null;

        obj = str;

        Date date = new Date();
//        str = date; // 编译不通过

        Object[] arrObj = null;
        String[] arrStr = null;

        arrObj = arrStr;

        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;   // 编译不通过
    }

}