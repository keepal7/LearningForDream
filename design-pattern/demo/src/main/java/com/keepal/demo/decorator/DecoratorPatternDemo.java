package com.keepal.demo.decorator;

import java.io.*;

/**
 * 装饰模式的核心思想：增强对象本身，最经典的例子就是IO流中的修饰流
 */
public class DecoratorPatternDemo {

    /**
     * 装饰模式的实现：
     * 就是和目标类实现相同的接口，然后传入需要增强的类的引用，
     * 接着在调用原有函数前后做对应的功能增强
     *
     * 装饰模式和代理模式在代码上是一样的
     * 差异点在思想上：
     * 装饰模式思想是增强自己本身的能里像io流，
     * 代理模式是做一些核心功能之外的事情，例如处理事务等
     */
    public static void main(String[] args) throws Exception {
        Component component = new ConcreteComponent();
        Component decorator = new Decorator(component);
        decorator.execute();
        // 经典的装饰模式
        // InputStreamReader增强了InputStreamReader，让原本只能读字节数组的能读取char[]
        // BufferedReader增强了InputStreamReader，让读取char[]可以直接按照整行读取
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream("")));
    }

    public interface Component {
        void execute();
    }

    public static class ConcreteComponent implements Component {

        public void execute() {
            System.out.println("执行基础功能");
        }

    }

    public static class Decorator implements Component {

        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        public void execute() {
            System.out.println("在执行基础功能之前，执行部分功能增强");
            component.execute();
            System.out.println("在执行基础功能之后，执行部分功能增强");
        }

    }

}