package com.keepal.demo.facade;

/**
 * 在没有使用外观模式的demo
 */
public class WithoutFacadePatternDemo {


    /**
     * 场景：存在两个子系统ModuleA/ModuleB
     * 然后ModuleA中有三个子模块，现在ModuleB需要使用这三个子模块
     *
     * 存在的问题：
     * 1、子模块一多的话，对于调用方来说，组成一个功能会很繁琐
     * 2、如果这种复制粘贴的地方太多了，一旦组合出现变化，就是大面积修改，不利于维护
     */
    public static void main(String[] args) {
        ModuleA moduleA1 = new ModuleaA1();
        ModuleA moduleA2 = new ModuleaA2();
        ModuleA moduleA3 = new ModuleaA3();

        moduleA1.exec();
        moduleA2.exec();
        moduleA3.exec();
    }


    public static interface ModuleA {
        void exec();
    }

    public static class ModuleaA1 implements ModuleA{

        public void exec() {
            System.out.println("ModuleaA1");
        }
    }
    public static class ModuleaA2 implements ModuleA{

        public void exec() {
            System.out.println("ModuleaA2");
        }
    }
    public static class ModuleaA3 implements ModuleA{

        public void exec() {
            System.out.println("ModuleaA3");
        }
    }
}
