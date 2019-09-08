package com.straymalone.java8demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {

    List<Person> personList = new ArrayList<>();

    {
        personList.add(new Person("王五", 30, "看书", 10000));
        personList.add(new Person("张三", 18, "玩游戏", 0));
        personList.add(new Person("李四", 24, "玩游戏", 5000));
        personList.add(new Person("赵四", 24, "旅游", 8000));
    }

    @Test
    public void test1() {
        // 找出年龄都是24岁的人
        List<Person> result = personList.stream()
                .filter(person -> person.getAge() == 24)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void test2() {
        // 找出年龄都是24岁的人
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge() == 24) {
                result.add(person);
            }
        }
        System.out.println(result);
    }

    @Test
    public void test3() {

    }
}
