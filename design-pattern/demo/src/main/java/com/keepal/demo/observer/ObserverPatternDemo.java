package com.keepal.demo.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式，主要是用于消息通知类业务，有推/拉两种实现
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject(0);
        Observer myObserver = new MyObserver();
        // 添加当前这个事件的观察者
        subject.addObserver(myObserver);
        // 改变当前的对象
        subject.setState(1);
        subject.setState(2);
    }


    public static class Subject extends Observable {
        private Integer state;

        public Subject(Integer state) {
            this.state = state;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
            this.setChanged();
            // 推模式
//            this.notifyObservers(state);
            // 拉模式，也就是不把具体的改变值传过去，让观察者自己来拿
            this.notifyObservers();
        }
    }

    public static class MyObserver implements Observer {

        public void update(Observable o, Object arg) {
            // 推模式实现
//            Integer state = (Integer) arg;
//            System.out.println("状态改变为：" + state);
            // 拉模式——感知到以后自己去拿
            Subject subject = (Subject) o;
            System.out.println("状态改变为：" + subject.getState());
        }
    }
}
