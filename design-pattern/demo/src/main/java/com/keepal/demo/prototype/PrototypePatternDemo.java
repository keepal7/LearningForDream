package com.keepal.demo.prototype;

/**
 * 使用原型模型对数据拷贝进行抽取
 */
public class PrototypePatternDemo {

    /**
     * 其实就是将数据拷贝逻辑抽取到对应的对象类中，覆写clone函数
     * 统一管理数据拷贝的实现逻辑，对外只暴露cone()函数
     *
     * 浅拷贝：只拷贝基础数据类型，对于引用类型只是拷贝了一个引用，而没有拷贝其对象本身。
     * 深拷贝：在浅拷贝的基础上，遇到引用类型都创建一个对应新的对象。
     *
     */
    public static void main(String[] args) {
        Order order = new Order("1",new OrderAttr("2"));
        Order copyOrder = order.clone();
        System.out.println(copyOrder);
    }


    public static class Order{
        private String orderId;
        private OrderAttr orderAttr;

        public Order(String orderId, OrderAttr orderAttr) {
            this.orderId = orderId;
            this.orderAttr = orderAttr;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public OrderAttr getOrderAttr() {
            return orderAttr;
        }

        public void setOrderAttr(OrderAttr orderAttr) {
            this.orderAttr = orderAttr;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId='" + orderId + '\'' +
                    ", orderAttr=" + orderAttr +
                    '}';
        }

        /**
         * 需要递归拷贝对象中的引用类型对象
         * 一般都是采用序列化的方式来进行深拷贝
         */
        public Order clone(){
            // 深拷贝实现
            return new Order(getOrderId(), getOrderAttr().clone());
        }
    }
    public static class OrderAttr{
        private String name;

        public OrderAttr(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "OrderAttr{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public OrderAttr clone(){
            return new OrderAttr(getName());
        }

    }
}
