package com.keepal.demo.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    /**
     * 需要触发执行的事件
     */
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("系统启动了。。。");
    }

}