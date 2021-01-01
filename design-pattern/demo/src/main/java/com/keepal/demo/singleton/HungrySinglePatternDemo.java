package com.keepal.demo.singleton;

/**
 * 饿汉式：即不管用不用，我先初始化好。
 */
public class HungrySinglePatternDemo {

    public static void main(String[] args) {
        // 使用
        Singleton singleton = Singleton.SINGLETON;
    }

    public static class Singleton {
        // 1、内部成员变量，利用类加载的<client>函数只被执行一次来达到单例的目的。
        private static final Singleton SINGLETON = new Singleton();

        // 私有化构造器，禁止其他地方再创建此对象
        private Singleton(){}
    }
}
