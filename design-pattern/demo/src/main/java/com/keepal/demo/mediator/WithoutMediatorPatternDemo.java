package com.keepal.demo.mediator;

/**
 * 不使用中介者模式demo
 */
public class WithoutMediatorPatternDemo {

    /**
     * 场景：多个模块之间要相互调用
     *
     * 不使用中介者模式的问题:
     * 1.模块之间有非常复杂的互相之间的跟蜘蛛网一样的调用
     * 2.每个模块都要去care很多其他的模块，互相之间耦合很严重
     * 3.后面在修改代码的时候，代码不好改，模块B一旦修改了自己的代码，可能会影响模块A和模块C
     */
    public static void main(String[] args) {
        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }

    public static class ModuleA {

        public void execute() {
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();
            moduleB.execute("模块A");
            moduleC.execute("模块A");
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块A的功能");
        }

    }

    public static class ModuleB {

        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleC moduleC = new ModuleC();
            moduleA.execute("模块B");
            moduleC.execute("模块B");
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块B的功能");
        }

    }

    public static class ModuleC {

        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();
            moduleA.execute("模块C");
            moduleB.execute("模块C");
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块C的功能");
        }

    }
}
