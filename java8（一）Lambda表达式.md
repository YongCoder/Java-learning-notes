# java8（一）Lambda表达式

其实很久前已经学习过了Lambda表达式，但是学习后没有多少使用的机会，久而久之也就忘记（惭愧）。最近正好新的项目用的jdk8所以准备再学习一次，写下文章也是为了记录，方便以后再忘的时候，不用到处找资料（旁白：这么丢人的事，能别到处说吗）。

## 第一个Lambda表达式

```java
public class Java8Demo {

    public static void main(String[] args) {
        Greeting helloLambda = () -> System.out.println("Hello Lambda!");
        helloLambda.sayHello();
    }

    interface Greeting {
        void sayHello();
    }
}
```

