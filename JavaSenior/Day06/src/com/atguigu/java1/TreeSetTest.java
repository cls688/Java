package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author chenglongsheng
 * @create 2021-05-07 8:25
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加的对象要求是相同类的对象
    2.两种排序：自然排序（实现Comparable接口） 和 定制排序（Comparator）

    3.自然排序中，比较两个对象是否相同的标准：compareTo()返回0，不再是equals()
    3.定制排序中，比较两个对象是否相同的标准：compare()返回0，不再是equals()
     */
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

//        set.add(12);
//        set.add(45);
//        set.add(6);
//        set.add(90);
//        set.add(-87);

        set.add(new User("Jerry", 34));
        set.add(new User("Tom", 56));
        set.add(new User("Jin", 34));
        set.add(new User("Jack", 94));
        set.add(new User("An", 14));
        set.add(new User("Mike", 34));
        set.add(new User("Mike", 57));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            // 按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("输入类型不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new User("Jerry", 34));
        set.add(new User("Tom", 56));
        set.add(new User("Jin", 34));
        set.add(new User("Jack", 94));
        set.add(new User("An", 14));
        set.add(new User("Mike", 34));
        set.add(new User("Mike", 57));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
