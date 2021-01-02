package com.keepal.demo.chain;

/**
 * 不使用责任链
 */
public class WithoutChainPatternDemo {

    /**
     * 场景：
     * （1）现在在某一个地方的业务流程，要执行功能1、功能2、功能3
     * （2）现在在另外一个地方的业务流程，是要先执行功能3，然后执行功能1和功能2
     *
     * 存在的问题:
     * 1、大量的重复代码
     * 2、业务的处理不够灵活，无法插拔和动态调整
     */
    public static void main(String[] args) {
        System.out.println("执行业务1");
        System.out.println("执行业务2");
        System.out.println("执行业务3");
        // 其他地方又执行
        System.out.println("执行业务3");
        System.out.println("执行业务1");
        System.out.println("执行业务2");
    }
}
