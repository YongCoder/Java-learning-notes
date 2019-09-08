package com.straymalone.java8demo;

public class Person {

    private String name;
    private int age;
    private String hobby;
    private double salary;

    public Person(String name, int age, String hobby, double salary) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", salary=" + salary +
                '}';
    }
}
