package com.keepal.demo.factory;

/**
 * 没有使用工厂方法模式来创建对象的demo
 */
public class WithoutFactoryMethodPartternDemo {

    /**
     * 场景：
     * 当使用简单工厂去创建对象的时候，有些通用逻辑分散到各个工厂实现的话，会有重复代码，也很难维护
     */
    public static void main(String[] args) {
        User u1 = UserFactory1.create();
        User u2 = UserFactory2.create();
        User u3 = UserFactory3.create();
    }


    public static class UserFactory1 {
        static User create() {
            System.out.println("通用的User创建逻辑");
            System.out.println("User1特殊的创建逻辑");
            return new User1();
        }
    }

    public static class UserFactory2 {
        static User create() {
            System.out.println("通用的User创建逻辑");
            System.out.println("User2特殊的创建逻辑");
            return new User2();
        }
    }

    public static class UserFactory3 {
        static User create() {
            System.out.println("通用的User创建逻辑");
            System.out.println("User3特殊的创建逻辑");
            return new User3();
        }
    }


    public static interface User {
        void exec();
    }

    public static class User1 implements User {

        public void exec() {

        }
    }

    public static class User2 implements User {

        public void exec() {

        }
    }

    public static class User3 implements User {

        public void exec() {

        }
    }
}
