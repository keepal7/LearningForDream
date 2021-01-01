package com.keepal.demo.factory;

/**
 * 不使用抽象工厂来创建对象组合
 */
public class WithoutAbstractFactoryPartternDemo {

    /**
     * 这种组合使用的方式，如果一旦组合需要变动，设计改动的代码就会很多。
     */
    public static void main(String[] args) {
        // userA1 + userB1
        UserA userA1 = new UserA1("a1");
        UserB userB1 = new UserB1("b1");

    }


    public static interface UserA {
    }

    public static interface UserB {
    }

    public static class UserA1 implements UserA {
        private String name;

        public UserA1(String name) {
            this.name = name;
        }
    }

    public static class UserA2 implements UserA {
        private String name;

        public UserA2(String name) {
            this.name = name;
        }
    }

    public static class UserA3 implements UserA {
        private String name;

        public UserA3(String name) {
            this.name = name;
        }
    }

    public static class UserB1 implements UserB {
        private String name;

        public UserB1(String name) {
            this.name = name;
        }
    }

    public static class UserB2 implements UserB {
        private String name;

        public UserB2(String name) {
            this.name = name;
        }
    }

    public static class UserB3 implements UserB {
        private String name;

        public UserB3(String name) {
            this.name = name;
        }
    }
}
