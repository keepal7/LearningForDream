package com.keepal.demo.factory;

/**
 * 使用工厂模式创建对象
 */
public class FactoryPartternDemo {

    public static void main(String[] args) {
        // 面向接口来管理和使用对象
        User user = UserFactory.create();
        user.exec();
    }

    public static class UserFactory {
        // 只需要修改创建函数，而不需要修改调用的地方
        public static User create() {
            return new User2();
        }
    }

    public static interface User {
        public void exec();
    }

//    public static class User1 implements User {
//        public void exec() {
//            System.out.println("user1 的实现");
//        }
//    }

    /**
     * 如果后续修改了原有的User1
     * 用User2替代了，那么很简单，只需要修改工厂的创建函数即可
     */
    public static class User2 implements User {
        public void exec() {
            System.out.println("user1 的实现");
        }
    }
}
