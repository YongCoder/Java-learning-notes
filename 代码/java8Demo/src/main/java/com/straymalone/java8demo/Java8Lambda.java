package com.straymalone.java8demo;

import org.junit.Test;

import java.util.function.BinaryOperator;

public class Java8Lambda {

    @Test
    public void test1() {
        // lambda表达式
        Greeting helloLambda = (name) -> "Hello! " + name;
        // 调用方法
        System.out.println(helloLambda.sayHello("Lambda"));
    }

    @Test
    public void test2() {
        // 匿名类的写法
        Greeting helloLambda = new Greeting() {
            @Override
            public String sayHello(String name) {
                return "Hello! " + name;
            }
        };
        // 调用方法
        System.out.println(helloLambda.sayHello("Lambda"));
    }

    @Test
    public void test3() {
        // 去除外壳，保留方法参数和方法体，并在参数和方法体之间加上符号->
        Greeting helloLambda =(String name) -> {
                return "Hello! " + name;
            };
        // 调用方法
        System.out.println(helloLambda.sayHello("Lambda"));
    }

    @Test
    public void test4() {
        // 去除return和{}
        Greeting helloLambda =(String name) -> "Hello! " + name;
        // 调用方法
        System.out.println(helloLambda.sayHello("Lambda"));
    }

    @Test
    public void test5() {
        // 去除参数类型和圆括号（只有一个参数的时候，才可以去掉圆括号）
        Greeting helloLambda = name -> "Hello! " + name;
        // 调用方法
        System.out.println(helloLambda.sayHello("Lambda"));
    }

    @Test
    public void test6() {
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        // 调用方法
        System.out.println(addLongs.apply(2L, 3L));
    }

    interface Greeting {
        String sayHello(String name);
    }
}
