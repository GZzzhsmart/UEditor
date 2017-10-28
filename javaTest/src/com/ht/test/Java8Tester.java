package com.ht.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * jdk7与jdk8的编程格式和风格
 */
public class Java8Tester {


    public static void main(String[] args){
        List<String> list = new ArrayList <>();
        list.add("me");
        list.add("person");

        List<String> list1 = new ArrayList <>();
        list1.add("me");
        list1.add("person");

        Java8Tester tester = new Java8Tester();
        System.out.println("使用 Java 7 语法: ");

        tester.sortUsingJava7(list);
        System.out.println(list1);
        System.out.println("使用 Java 8 语法: ");

        tester.sortUsingJava8(list1);
        System.out.println(list1);

    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
