package com.innings2023.leetcode.oops;

import java.util.Map;

public class Base {
    public void method(Object obj){
        System.out.println("Method1");
    }
    public void method(String obj){
        System.out.println("Method2");
    }

    public void method(Map<String, String> obj){
        System.out.println("Method5");
    }
}
