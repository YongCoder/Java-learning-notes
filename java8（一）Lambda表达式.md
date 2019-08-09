# java8（一）Lambda表达式

其实很久前已经学习过了Lambda表达式，但是学习后没有多少使用的机会，久而久之也就忘记（惭愧）。最近正好新的项目用的jdk8所以准备再学习一次，写下文章也是为了记录，方便以后再忘的时候，不用到处找资料（旁白：这么丢人的事，能别到处说吗）。

## 语法

```
(参数) -> 表达式

或

(参数) -> {表达式}
```

## 第一个Lambda表达式

```java
public class Java8Lambda {

    @Test
    public void test1() {
        // lambda表达式
        Greeting helloLambda = (name) -> "Hello! " + name;
        // 调用方法
        System.out.println(helloLambda.sayHello("Lambda"));
    }

    interface Greeting {
        String sayHello(String name);
    }
}
```

输出结果：

```
Hello! Lambda
```

Lambda表达式可以看成是匿名类一点点**演变过来**

1. 匿名类的写法

```java
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
```

设计匿名内部类的目的，就是为了方便java程序员将代码作为数据传递。不过匿名内部类还是不够简便。

2. 去除外壳，保留方法参数和方法体，并在参数和方法体之间加上符号->

```java
@Test
public void test3() {
    // 去除外壳，保留方法参数和方法体，并在参数和方法体之间加上符号->
    Greeting helloLambda =(String name) -> {
            return "Hello! " + name;
        };
    // 调用方法
    System.out.println(helloLambda.sayHello("Lambda"));
}
```

3. 去除return和{}

```java
@Test
public void test4() {
    // 去除return和{}
    Greeting helloLambda =(String name) -> "Hello! " + name;
    // 调用方法
    System.out.println(helloLambda.sayHello("Lambda"));
}
```

4. 去除参数类型和圆括号（只有一个参数的时候，才可以去掉圆括号）

```java
@Test
public void test5() {
    // 去除参数类型和圆括号（只有一个参数的时候，才可以去掉圆括号）
    Greeting helloLambda = name -> "Hello! " + name;
    // 调用方法
    System.out.println(helloLambda.sayHello("Lambda"));
}
```

从test2到test5代码一步步变的简介紧凑，**与匿名类相比Lambda更加简洁**。

## 类型推断

某些情况下，用户需要手动指明Lambda参数的类型，例如：

```java
@Test
public void test6() {
    BinaryOperator<Long> addLongs = (x, y) -> x + y;
    // 调用方法
    System.out.println(addLongs.apply(2L, 3L));
}
```

这时将泛型<Long>去掉编译器将会报错，提示如下：

```
Error:(58, 47) java: 二元运算符 '+' 的操作数类型错误
  第一个类型:  java.lang.Object
  第二个类型: java.lang.Object
```

BinaryOperator 毕竟是一个具有泛型参数的函数接口， 该类型既是参数 x 和 y 的类型， 也是返回值的类型。 上面的例子中并没有给出变量add 的任何泛型信息， 给出的正是原始类型的定义。 因此， 编译器认为参数和返回值都是java.lang.Object 实例。 

所以这个时候如果没有泛型就会编译报错。

##Lambda表达式的重要特征

* 可选的类型声明：有时省略类型信息可以减少干扰，更易弄清状况；而有时却需要类型信息帮助理解代码

* 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号
* 可选的大括号：如果主题包含了一个语句，就不需要使用大括号
* 可选的返回关键字：如果主题只有一个表达式返回值则编译器会自动返回值，如果使用大括号说明不止一个语句，必须声明返回值。