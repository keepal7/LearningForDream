package com.keepal.demo.chain;

/**
 * 使用责任链
 */
public class ChainPatternDemo {


    /**
     * 核心思想：
     * 1、将各个业务逻辑抽取成handler
     * 2、handler在初始化的时候指定后续的handler，然后达到向后传递的效果
     *
     * 这样做的话，各个handler在组成业务的时候，就比较灵活了，可以任意组装和调整顺序
     */
    public static void main(String[] args) {
        Handler thirdHandler = new Handler3(null);
        Handler secHandler = new Handler2(thirdHandler);
        Handler firstHandler = new Handler1(secHandler);
        firstHandler.exec();

        // 在其他地方调用
        firstHandler = new Handler2(null);
        secHandler = new Handler1(firstHandler);
        firstHandler = new Handler3(secHandler);
        firstHandler.exec();

    }

    public static abstract class Handler {
        // 用这个属性，来标识当前handler的下一个需要执行的handler
        // 这样每次初始化当前handler的时候，都需要指定后续的handler保存在这里
        // 从而达到了一直往后的传递的效果
        protected Handler successor;

        public Handler(Handler successor) {
            this.successor = successor;
        }

        public abstract void exec();
    }

    public static class Handler1 extends Handler {

        public Handler1(Handler successor) {
            super(successor);
        }

        public void exec() {
            System.out.println("执行handler1");
            if (successor != null) {
                successor.exec();
            }
        }
    }

    public static class Handler2 extends Handler {

        public Handler2(Handler successor) {
            super(successor);
        }

        public void exec() {
            System.out.println("执行handler2");
            if (successor != null) {
                successor.exec();
            }
        }
    }

    public static class Handler3 extends Handler {

        public Handler3(Handler successor) {
            super(successor);
        }

        public void exec() {
            System.out.println("执行handler3");
            if (successor != null) {
                successor.exec();
            }
        }
    }
}
