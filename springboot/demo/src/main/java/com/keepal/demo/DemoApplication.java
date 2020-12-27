package com.keepal.demo;

import com.keepal.demo.config.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot的核心注解之一，负责自动配置/装配
 * 当我们引入一个starter的时候，会自动根据我们引入了什么依赖来判断我们要做什么事情，来完成对应的所有配置
 * <p>
 * 例如我们引入了starter-web，此时就会进入自动装配，
 * 完成web系统所需的所有配置，例如spring mvc的配置，web.xml的配置，tomcat的配置这些。
 * <p>
 * 它所要达到的效果，就是自动给我们按照约定完成一些所需的装配，
 * 不需要我们手动去配置一大堆的xml
 */
//@EnableAutoConfiguration

/**
 * 这是spring mvc的一个注解，
 * @RestController = @ResponseBody + @Controller，其实就是更加简洁了一些。（你设置啥返回类型直接给你返回啥类型）
 * 1、标识这是一个controller
 * 2、就仅仅提供RESTful接口，返回给浏览器，不走传统的渲染模板视图那一套。
 */
//@RestController

/**
 * 猜想一下springboot的启动流程：
 * 1、通过enableAutoConfiguration注解完成所有自动装配
 * 2、将内嵌的tomcat准备好，并将工程嵌入部署到嵌入的tomcat中
 * 3、启动tomcat容器
 * 4、tomcat启动之后，初始化spring的容器，和spring mvc整合到一起
 * 5、spring核心容器就会去扫描所有的包，看有没有带@RestController的注解，如果有就初始化这个controller
 * 6、将这个controller类实例化为一个bean，然后将bean注入都spring容器中
 * 7、此时spring mvd的核心servlet接收到请求之后，就会将请求转发给对应的controller bean
 * 8、controller bean处理完请求之后，spring mvc将请求返回给浏览器
 *
 */

/**
 * spring的核心思想就是消除各种复杂的xml配置
 * 因此一些复杂的xml配置都可以写在configuration类中，这个类由@Configuration标识
 */
//@Configuration

/**
 * 这个注解主要是用于扫描装配bean，用以取代xml式的bean配置文件
 */
//@ComponentScan

/**
 * 这个注解相当于：
 * =Configuration + @EnableAutoConfiguration + @ComponentScan组合
 */
@SpringBootApplication
/**
 * 导入配置类
 */
@Import(DruidDataSourceConfig.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
