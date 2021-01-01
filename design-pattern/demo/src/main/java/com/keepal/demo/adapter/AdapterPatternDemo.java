package com.keepal.demo.adapter;

/**
 * 使用适配器模式的demo
 */
public class AdapterPatternDemo {

    /**
     * 通过构造一个Adapter类，去实现新版本的接口——NewInterface
     * 然后在Adapter持有原OldInterface的引用，在使用的时候传入oldImpl，然后调用原本的实现
     * 从而通过Adapter兼容了老版本的实现，又打成了调用时的风格统一。
     */
    public static void main(String[] args) {
        NewInterfaceAdapter adapter = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newInterface = new NewInterfaceImpl();
        adapter.NewMethod();
        newInterface.NewMethod();
    }


    /**
     * 新增一个Adapter实现newInterface，
     * 然后内部持有OldInterface的引用，达到兼容的效果。
     */
    public static class NewInterfaceAdapter implements NewInterface {

        private OldInterface oldInterface;

        public NewInterfaceAdapter(OldInterface oldInterface) {
            this.oldInterface = oldInterface;
        }

        public void NewMethod() {
            oldInterface.OldMethod();
        }
    }

    public static interface OldInterface {
        public void OldMethod();
    }

    public static class OldInterfaceImpl implements OldInterface {

        public void OldMethod() {
            System.out.println("执行oldInterface的函数");
        }
    }

    public static interface NewInterface {
        public void NewMethod();
    }

    public static class NewInterfaceImpl implements NewInterface {

        public void NewMethod() {
            System.out.println("执行newInterface的函数");
        }
    }

}
