## 什么是流？

java8API添加了一个新的抽象称为流（Stream），可以让你以一种声明的方式处理数据。

流（Stream）可以极大提高java程序员的生产力，让程序员写出高效率、干净、和简洁的代码。

那么流（Stream）是用来对什么数据进行操作呢？

答案是**集合**，流通常是对集合进行操作，方便对集合进行筛选、排序、转换等等一系列操作。集合是java中使用最多的API。要是没有集合，还能做什么呢？几乎每个java应用程序都会制造和处理集合。集合对于很多编程任务来说都是非常基本的：它们可以让你把数据分组并加以处理。

## 第一个Stream代码

```java
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
}
```

那么在没有流（Stream）之前我们是怎么实现上面的条件呢？

```java
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
```

通过上面的例子我觉得流的操作更像数据库的操作，将数据提前存储起来，然后通过查询语句查询出想要的数据。举个例子，比如和上面例子一样我想在一群人里找出年龄是24岁的人，使用传统方法我们需要去找到每一个人确认他是不是24岁，而使用流（Stream）就相当于在人群中大喊一句请年龄24岁的人到我这边来。

## 使用流

流的使用一般包括三件事：

1. 一个数据源（如集合）来执行一个查询，比如上面例子中的personList
2. 一个中间操作链，形成一条流的流水线，比如上面例子中的filter操作
3. 一个终端操作，执行流水线，并能生成结果，比如上面例子中的collect操作

## 参考资料

1. 《Java 8函数式编程》
2. 《Java 8实战》