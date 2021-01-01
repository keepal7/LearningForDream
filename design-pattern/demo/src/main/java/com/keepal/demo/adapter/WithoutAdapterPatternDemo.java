package com.keepal.demo.adapter;


/**
 * 没有使用适配器的demo
 *
 *
 */
public class WithoutAdapterPatternDemo {


    /**
     * 场景：
     * 一个系统中，随着迭代，存在一个模块的两个版本的接口，现在需要在新的接口中兼容以前老接口的实现
     *
     * 问题：
     * 如果说直接这么显式的调用oldInterfaceImpl
     * 会导致系统中有两种不同的实现，会显得很乱，风格不统一，理解和维护的成本都增加了。
     */
    public static void main(String[] args) {
        OldInterface oldObj = new OldInterfaceImpl();
        NewInterface newObj= new NewInterfaceImpl();
        oldObj.OldMethod();
        newObj.NewMethod();
    }


    public static interface OldInterface{
        public void OldMethod();
    }

    public static class OldInterfaceImpl implements OldInterface {

        public void OldMethod() {
            System.out.println("执行oldInterface的函数");
        }
    }

    public static interface NewInterface{
        public void NewMethod();
    }

    public static class NewInterfaceImpl implements NewInterface {

        public void NewMethod() {
            System.out.println("执行newInterface的函数");
        }
    }
}
