package com.ht.test;

import java.util.*;
/**
 * 方法的引用
 */
public class Method {
    public static void main(String...args){
        List names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
