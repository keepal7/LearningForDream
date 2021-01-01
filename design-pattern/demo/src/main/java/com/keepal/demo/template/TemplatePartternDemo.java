package com.keepal.demo.template;

/**
 * 使用模板方法设计模式的demo
 */
public class TemplatePartternDemo {

    /**
     * 模板方法，其实就是将重复的逻辑抽到父类中
     * 然后提供一个额外的方法去让子类实现，而父类中引用子类实现的函数
     *
     * 从而避免大量的重复以及修改的时候大面积修改，还降低了bug的风险
     */
    public static void main(String[] args) {

        Calculator calculator1 = new Calculator1();
        Calculator calculator2 = new Calculator2();
        Calculator calculator3 = new Calculator3();

        // 由于各个子类里面，并没有覆写calculate函数。
        // 所以在调用的时候，是直接调用的AbstractCalculator的calculate函数
        // 因此就成功加上了这段通用代码的逻辑
        // 接着调用specialCalculate函数的时候，由于实际引用的是各个子类的对象
        // 因此调用的都是各个子类的specialCalculate实现。
        calculator1.calculate();
        calculator2.calculate();
        calculator3.calculate();
    }

    public static abstract class AbstractCalculator implements Calculator {

        public void calculate() {
            System.out.println("通用的计算逻辑,修改了一次");
            specialCalculate();
        }

        public abstract void specialCalculate();
    }

    public static interface Calculator {

        void calculate();
    }

    public static class Calculator1 extends AbstractCalculator {
        public void specialCalculate() {
            System.out.println("第一种特殊的计算方式");
        }
    }

    public static class Calculator2 extends AbstractCalculator {
        public void specialCalculate() {
            System.out.println("第二种特殊的计算方式");
        }
    }

    public static class Calculator3 extends AbstractCalculator {
        public void specialCalculate() {
            System.out.println("第三种特殊的计算方式");
        }
    }

}
