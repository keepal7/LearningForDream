package com.keepal.demo.strategy;

/**
 * 使用策略模式来优化长串的if/else
 */
public class StrategyPatternDemo {


    /**
     * 策略模式的本质，是将各个if/else拆分成单个handler子类
     * 然后由context统一调度
     *
     * 这里选择的实现方式是由Factory来承担具体的if/else选择，然后拿到具体的strategy实现类
     *
     * 还有一种优雅的方式，基于spring bean来做，在context中维护一个handlerMap，
     * key是对应handler的标识id，然后val是对应handler的实现
     * 其实现方式是根据spring容器拿到handler父类类型的所有子类实现，
     * 然后调用子类统一实现的getType子类，获取到key值
     */
    public static void main(String[] args) {
        int n = 1;
        DiscountCalculateStrategy strategy = DiscountCalculateStrategyFactory.create(n);
        Context context = new Context(strategy);
        context.calculate();
    }


    public interface DiscountCalculateStrategy {

        void calculate();

    }

    public static class DiscountCalculateStrategyA implements DiscountCalculateStrategy {

        public void calculate() {
            System.out.println("执行优惠计价方式1的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyB implements DiscountCalculateStrategy {

        public void calculate() {
            System.out.println("执行优惠计价方式2的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyC implements DiscountCalculateStrategy {

        public void calculate() {
            System.out.println("执行优惠计价方式3的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyDefault implements DiscountCalculateStrategy {

        public void calculate() {
            System.out.println("执行默认的优惠计价方式的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyFactory {
        public static DiscountCalculateStrategy create(int discountStyle) {
            if (discountStyle == 1) {
                return new DiscountCalculateStrategyA();
            } else if (discountStyle == 2) {
                return new DiscountCalculateStrategyB();
            } else if (discountStyle == 3) {
                return new DiscountCalculateStrategyC();
            } else {
                return new DiscountCalculateStrategyDefault();
            }
        }
    }

    public static class Context {
        DiscountCalculateStrategy discountCalculateStrategy;

        public Context(DiscountCalculateStrategy discountCalculateStrategy) {
            this.discountCalculateStrategy = discountCalculateStrategy;
        }

        public void calculate() {
            discountCalculateStrategy.calculate();
        }
    }
}
