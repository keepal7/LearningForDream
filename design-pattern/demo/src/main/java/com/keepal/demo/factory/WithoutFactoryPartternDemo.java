package com.keepal.demo.factory;

/**
 * 没有使用工厂模式来创建对象的demo
 */
public class WithoutFactoryPartternDemo {

    /**
     * 这种直接面向真实类型来创建对象的方式
     * 一般原本的真实对象需要修改或者因为什么原因要废弃
     * 这个时候，所有调用的地方都需要修改，如此大面积的修改很容易出问题
     * 维护性和可扩展性都很差
     */
    public static void main(String[] args) {
        // 一旦原先的User类废弃，User变为了User1，
        // 那么所有调用的地方都要改
        User1 u = new User1("z");
    }


//    public static class User{
//        private String name;
//
//        public User(String name) {
//            this.name = name;
//        }
//    }
    public static class User1{
        private String name;

        public User1(String name) {
            this.name = name;
        }
    }
}
