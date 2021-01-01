package com.keepal.demo.builder;

/**
 * 使用builder设计模式来构造复杂对象
 */
public class BuilderPatternDemo {


    /**
     * 本质上就是将复杂字段处理逻辑封装到Builder中
     * 然后由Director来负责构造的过程
     * 以此来简化整个构造代码块，达到不错的可维护性
     */
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.build("1","2","3");
        System.out.println(product);
    }


    /**
     * Builder接口负责定义规范
     */
    public static interface Builder {
        void setField1(String field1);

        void setField2(String field2);

        void setField3(String field3);

        Product create();
    }

    /**
     * ConcreteBuilder负责抽取在设置属性前的复杂逻辑操作
     */
    public static class ConcreteBuilder implements Builder {

        private Product product = new Product();

        public void setField1(String field1) {
            System.out.println("在设置field1之前进行复杂的校验逻辑");
            product.setField1(field1);
        }

        public void setField2(String field2) {
            System.out.println("在设置field2之前进行复杂的校验逻辑");
            product.setField1(field2);
        }

        public void setField3(String field3) {
            System.out.println("在设置field3之前进行复杂的校验逻辑");
            product.setField1(field3);
        }

        public Product create() {
            return product;
        }
    }

    /**
     * 直接面向Builder，负责构造过程的实现
     */
    public static class Director{
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        /**
         * 实现构造的过程
         */
        public Product build(String field1, String field2, String field3) {
            builder.setField1(field1);
            builder.setField2(field2);
            builder.setField3(field3);
            return builder.create();
        }
    }

    public static class Product {

        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

    }
}
