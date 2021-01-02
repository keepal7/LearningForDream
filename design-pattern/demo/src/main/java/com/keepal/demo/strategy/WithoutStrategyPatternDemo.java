package com.keepal.demo.strategy;

/**
 * 不使用策略模式来处理连串的if/else
 */
public class WithoutStrategyPatternDemo {

    /**
     * 这种一长串的if/else会导致代码很难阅读和维护
     */
    public static void main(String[] args) {
        int discountStyle = 1;
        if (discountStyle == 1) {
            System.out.println("执行第1种优惠");
        } else if (discountStyle == 2) {
            System.out.println("执行第2种优惠");
        } else if (discountStyle == 3) {
            System.out.println("执行第3种优惠");
        } else {
            System.out.println("执行默认的优惠");
        }
    }
}
