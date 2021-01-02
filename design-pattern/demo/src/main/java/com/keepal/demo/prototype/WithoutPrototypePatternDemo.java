package com.keepal.demo.prototype;

/**
 * 不使用原型模式拷贝对象
 */
public class WithoutPrototypePatternDemo {

    /**
     * 场景：一个订单数据，需要拷贝其中的数据成为一个出库单
     *
     * 不使用设计模式的问题：
     * 拷贝的实现逻辑更改了的话，就需要大面积修改，不利于维护
     */
    public static void main(String[] args) {
        Order order = new Order("hh", new OrderAttr("whhh"));
        // 浅拷贝
        Order copyOrder = new Order(order.orderId, order.getOrderAttr());
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
    }
    public static class OrderAttr{
        private String name;

        public OrderAttr(String name) {
            this.name = name;
        }
    }
}
