package com.keepal.demo.factory;

/**
 * 使用抽象工厂，内部定义不同类型的返回函数
 * 针对每种组合提供一个Factory，然后由这个Factory来控制具体要实现的组合
 */
public class AbstractFactoryPartternDemo {

    /**
     * 针对每一种组合，提供一个Factory，然后由这个Factory来控制具体要实现的组合
     */
    public static void main(String[] args) {
        // 第一种组合由factory1来完成
        UserA userA1 = Factory1.get().createUserA();
        UserB userB1 = Factory1.get().createUserB();

        UserA userA2 = Factory2.get().createUserA();
        UserB userB2 = Factory2.get().createUserB();

    }


    public static interface Factory {
        UserA createUserA();

        UserB createUserB();
    }

    public static class Factory1 implements Factory {

        private static final Factory instance = new Factory1();

        private Factory1(){}

        public static Factory get(){
            return instance;
        }

        public UserA createUserA() {
            return new UserA1("z");
        }

        public UserB createUserB() {
            return new UserB1("z");
        }
    }

    public static class Factory2 implements Factory {

        private static final Factory instance = new Factory2();

        private Factory2(){}

        public static Factory get(){
            return instance;
        }

        public UserA createUserA() {
            return new UserA2("z");
        }

        public UserB createUserB() {
            return new UserB2("z");
        }
    }

    public static class Factory3 implements Factory {

        private static final Factory instance = new Factory3();

        private Factory3(){}

        public static Factory get(){
            return instance;
        }

        public UserA createUserA() {
            return new UserA3("z");
        }

        public UserB createUserB() {
            return new UserB3("z");
        }
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
