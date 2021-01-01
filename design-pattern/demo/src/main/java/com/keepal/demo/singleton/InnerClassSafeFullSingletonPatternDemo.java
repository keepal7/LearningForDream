package com.keepal.demo.singleton;

/**
 * 饱汉式
 * <p>
 * 线程绝对安全——利用类被初始化的时候，<client>函数只会被初始化一次
 */
public class InnerClassSafeFullSingletonPatternDemo {

    public static class Singleton {

        private Singleton() {
        }


        public static Singleton get() {
            return InnerHolder.SINGLETON;
        }

        /**
         * 这个类在上面的get函数没有被调用的情况下，是不会初始化的
         * 以此来达到饱汉式的效果
         */
        static class InnerHolder {
            private static final Singleton SINGLETON = new Singleton();
        }


    }
}
