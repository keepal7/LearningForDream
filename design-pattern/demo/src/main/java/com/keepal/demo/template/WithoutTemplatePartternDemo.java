package com.keepal.demo.template;

/**
 * 没有使用模板方法的demo
 */
public class WithoutTemplatePartternDemo {


    /**
     * 场景：现在有个计算器，存在一些公共的计算逻辑，以及三种特殊的计算逻辑
     *
     * 不使用模板方法的问题：
     * 1、大量重复代码
     * 2、一旦原先通用的代码逻辑需要修改，需要改动大量的地方，还可能该漏，造成bug
     */
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator1();
        Calculator calculator2 = new Calculator2();
        Calculator calculator3 = new Calculator3();

        calculator1.calculate();
        calculator2.calculate();
        calculator3.calculate();
    }

    public static interface Calculator {

        void calculate();
    }

    public static class Calculator1 implements Calculator {

        public void calculate() {
            System.out.println("通用的计算方式");
            System.out.println("第一种特殊的计算方式");
        }
    }

    public static class Calculator2 implements Calculator {

        public void calculate() {
            System.out.println("通用的计算方式");
            System.out.println("第二种特殊的计算方式");
        }
    }

    public static class Calculator3 implements Calculator {

        public void calculate() {
            System.out.println("通用的计算方式");
            System.out.println("第三种特殊的计算方式");
        }
    }
}
