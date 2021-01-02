package com.keepal.demo.mediator;

public class MediatorPatternDemo {


    /**
     * 中介者模式主要是为了解耦各个模块之间的调用关系
     * 让各个模块直接不感知彼此
     *
     * 这个实现方式是创建了一个中介类，里面持有各个模块的引用，
     * 接着针对每个模块所需的额外调用封装统一的方法，提供给对应的模块调用
     *
     * 对于各个模块而言，就只感知到中介，而对其他模块不再感知了
     */
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        ModuleA moduleA = new ModuleA(mediator);
        ModuleB moduleB = new ModuleB(mediator);
        ModuleC moduleC = new ModuleC(mediator);


        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }


    public static class Mediator {
        private ModuleA moduleA;
        private ModuleB moduleB;
        private ModuleC moduleC;

        public void invokeModuleA() {
            moduleB.execute("模块A通知中介者");
            moduleC.execute("模块A通知中介者");
        }

        public void invokeModuleB() {
            moduleA.execute("模块B通知中介者");
            moduleC.execute("模块B通知中介者");
        }

        public void invokeModuleC() {
            moduleA.execute("模块C通知中介者");
            moduleB.execute("模块C通知中介者");
        }


        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }
    }


    public static class ModuleA {

        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleA(this);
        }

        public void execute() {
            mediator.invokeModuleA();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块A的功能");
        }

    }

    public static class ModuleB {

        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleB(this);
        }

        public void execute() {
            mediator.invokeModuleB();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块B的功能");
        }

    }

    public static class ModuleC {

        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleC(this);
        }

        public void execute() {
            mediator.invokeModuleC();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块C的功能");
        }

    }
}
