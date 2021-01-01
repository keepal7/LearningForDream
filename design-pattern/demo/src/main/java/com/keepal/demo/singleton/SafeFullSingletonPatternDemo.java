package com.keepal.demo.singleton;

/**
 * 饱汉式：需要的时候才去初始化
 * <p>
 * 线程相对安全的,通过同步+double-check
 */
public class SafeFullSingletonPatternDemo {

    public static class Singleton {

        private static Singleton singleton;

        private static final Object LOCK = new Object();

        private Singleton() {
        }

        /**
         * 首先整个不可变的临界变量，通过这个对象来对创建过程进行同步操作
         * 在同步操作的时候需要进行double-check，因为可能当线程1在执行完创建赋值操作后，释放锁
         * 此时线程1切换到线程2，线程2拿到锁，直接再次创建赋值，此时线程1创建的那个单例对象就没有引用了
         * 就只能等待GC去回收掉。
         *
         * 但是这个操作也并不是100%线程安全的，因为JVM不同的编译器的情况下，可能会出问题。TODO
         *
         */
        public Singleton get() {
            if (singleton == null) {
                synchronized (LOCK) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }


    }
}
