方法引用让你可以重复使用现有的方法定义，并像 Lambda 一样进行传递。

方法引用可以被看作仅仅调用特定方法的 Lambda 的一种快捷写法。

事实上，方法引用就是让你根据已有的方法实现来创建 Lambda 表达式。

例：

```java
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

interface Chat {
    void say(String word);
}
```

test1是 Lambda 表达式写法，通过调用 println 方法输出 content。test2 是方法引用，这里看起来方法引用更加的简洁明了。看完例子，再来看看语法。

## 语法

这里把方法引用分为5种

1.静态方法引用：ClassName::staticMethod

2.特定类的任意对象的方法引用：ClassName::instanceMethod

3.特定对象的方法引用：instance::instanceMethod

4.构造器引用：ClassName::new

5.数组引用：ClassName[]::new

## 举例

语法没看懂，没关系，我们举例来说明-_-

**1.静态方法引用**

```java
@Test
public void test3() {
    // Function<T,R> 接受一个输入参数，返回一个结果。(java8定义的函数式接口)
    Function<Integer, String> f1 = (s) -> String.valueOf(s); // 将传入的类型转换成String
    System.out.println(f1.apply(100) + 200); // 输出100200

    Function<Integer, String> f2 = String::valueOf; // 将传入的类型转换成String
    System.out.println(f2.apply(100) + 200); // 输出100200
}
```

**2.特定类的任意对象的方法引用**

```java
@Test
public void test4() {
    // Function<T,R> 接受一个输入参数，返回一个结果。(java8定义的函数式接口)
    Function<String, Integer> f1 = (s) -> s.length(); // 返回字符串长度
    System.out.println(f1.apply("hello")); // 输出5

    Function<String, Integer> f2 = String::length; // 返回字符串长度
    System.out.println(f2.apply("hello")); // 输出5
}
```

**3.特定对象的方法引用**

```java
@Test
public void test5() {
    String s = "hello";
    // IntSupplier 无参数，返回一个int类型结果。(java8定义的函数式接口)
    IntSupplier intSupplier1 = () -> s.length(); // 返回字符串长度
    System.out.println(intSupplier1.getAsInt()); // 输出5

    IntSupplier intSupplier2 = s::length; // 返回字符串长度
    System.out.println(intSupplier2.getAsInt()); // 输出5
}
```

**4.构造器引用**

```java
@Test
public void test6() {
    // Supplier<T> 无参数，返回一个结果。(java8定义的函数式接口)
    List list1 = this.getList(() -> new ArrayList());

    List list2 = this.getList(ArrayList::new);
}

public static List getList(Supplier<List> s){
    return s.get();
}
```

**5.数组引用**

```java
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
```

## 参考资料

1. <http://how2j.cn/p/2807>
2. 《Java 8函数式编程》
3. 《Java 8实战》