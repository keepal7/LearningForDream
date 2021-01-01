package com.keepal.demo.singleton;

/**
 * 饱汉式：需要的时候才去初始化
 * <p>
 * 线程不安全的
 */
public class UnsafeFullSingletonPatternDemo {

    /**
     * 这种实现方式没有考虑多线程并发的场景
     * 很可能在多线程场景下创建出多个Singleton实例
     */
    public static class Singleton {

        private static Singleton singleton;

        private Singleton() {
        }

        public Singleton get() {
            if (singleton == null) {
                singleton = new Singleton();
            }
            return singleton;
        }


    }
}
