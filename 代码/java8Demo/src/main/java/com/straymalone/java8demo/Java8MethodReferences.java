package com.straymalone.java8demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Java8MethodReferences {

    @Test
    public void test1() {
        Chat chat = (content) -> System.out.println(content);
        chat.say("hello!");
    }

    @Test
    public void test2() {
        Chat chat = System.out::println;
        chat.say("hello!");
    }

    // 静态方法引用
    @Test
    public void test3() {
        // Function<T,R> 接受一个输入参数，返回一个结果。(java8定义的函数式接口)
        Function<Integer, String> f1 = (s) -> String.valueOf(s); // 将传入的类型转换成String
        System.out.println(f1.apply(100) + 200); // 输出100200

        Function<Integer, String> f2 = String::valueOf; // 将传入的类型转换成String
        System.out.println(f2.apply(100) + 200); // 输出100200
    }

    // 特定类的任意对象的方法引用
    @Test
    public void test4() {
        // Function<T,R> 接受一个输入参数，返回一个结果。(java8定义的函数式接口)
        Function<String, Integer> f1 = (s) -> s.length(); // 返回字符串长度
        System.out.println(f1.apply("hello")); // 输出5

        Function<String, Integer> f2 = String::length; // 返回字符串长度
        System.out.println(f2.apply("hello")); // 输出5
    }

    // 特定对象的方法引用
    @Test
    public void test5() {
        String s = "hello";
        // IntSupplier 无参数，返回一个int类型结果。(java8定义的函数式接口)
        IntSupplier intSupplier1 = () -> s.length(); // 返回字符串长度
        System.out.println(intSupplier1.getAsInt()); // 输出5

        IntSupplier intSupplier2 = s::length; // 返回字符串长度
        System.out.println(intSupplier2.getAsInt()); // 输出5
    }

    // 构造器引用
    @Test
    public void test6() {
        // Supplier<T> 无参数，返回一个结果。(java8定义的函数式接口)
        List list1 = this.getList(() -> new ArrayList());

        List list2 = this.getList(ArrayList::new);
    }

    public static List getList(Supplier<List> s){
        return s.get();
    }

    // 数组引用
    @Test
    public void test7() {
        // Function<T,R> 接受一个输入参数，返回一个结果。(java8定义的函数式接口)
        Function<Integer, String[]> f1 = length -> new String[length];
        String[] strs = f1.apply(10);
        System.out.println(strs.length); // 输出10

        Function<Integer,String[]> f2 = String[]::new;
        strs = f2.apply(10);
        System.out.println(strs.length); // 输出10
    }

    interface Chat {
        void say(String word);
    }
}
