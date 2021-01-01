package com.keepal.demo.factory;

/**
 * 使用工厂方法模式创建对象
 */
public class FactoryMethodPartternDemo {

    /**
     * 在使用工厂模式的时候，遇到有通用逻辑，可以按照模板方法抽出公共的父类Factory
     * 然后由父类去完成通用逻辑，提供额外函数给子类去自实现即可。
     */
    public static void main(String[] args) {
        User u1 = UserFactory1.get().create();
        User u2 = UserFactory2.get().create();
        User u3 = UserFactory3.get().create();
    }


    public static abstract class AbstractUserFactory {
        public User create() {
            System.out.println("通用的User创建逻辑");
            return specialCreate();
        }

        protected abstract User specialCreate();
    }

    public static class UserFactory1 extends AbstractUserFactory {
        private static final UserFactory1 instance = new UserFactory1();

        public static UserFactory1 get(){
            return instance;
        }
        protected User specialCreate() {
            System.out.println("User1特殊的创建逻辑");
            return new User1();
        }
    }

    public static class UserFactory2 extends AbstractUserFactory {
        private static final UserFactory2 instance = new UserFactory2();

        public static UserFactory2 get(){
            return instance;
        }
        protected User specialCreate() {
            System.out.println("User2特殊的创建逻辑");
            return new User2();
        }
    }

    public static class UserFactory3 extends AbstractUserFactory {
        private static final UserFactory3 instance = new UserFactory3();

        public static UserFactory3 get(){
            return instance;
        }
        protected User specialCreate() {
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
