package com.keepal.demo.facade;

/**
 * 利用外观模式的demo
 */
public class FacadePatternDemo {

    /**
     * 其实就是弄个外观类把一整块功能给封装起来
     * 让调用方面向外观进行调用，而不感知内部的实现方式
     *
     * 这样的话，无论里面我怎么修改，调用方都不感知。
     */
    public static void main(String[] args) {
        ModuleAFacade facade = new ModuleAFacade();
        facade.execOneThing();
    }


    public static class ModuleAFacade {
        void execOneThing() {
            ModuleA moduleA1 = new ModuleaA1();
            ModuleA moduleA2 = new ModuleaA2();
            ModuleA moduleA3 = new ModuleaA3();

            moduleA1.exec();
            moduleA2.exec();
            moduleA3.exec();
            System.out.println("我修改了一些东西");
        }
    }

    public static interface ModuleA {
        void exec();
    }

    public static class ModuleaA1 implements ModuleA {

        public void exec() {
            System.out.println("ModuleaA1");
        }
    }

    public static class ModuleaA2 implements ModuleA {

        public void exec() {
            System.out.println("ModuleaA2");
        }
    }

    public static class ModuleaA3 implements ModuleA {

        public void exec() {
            System.out.println("ModuleaA3");
        }
    }
}
