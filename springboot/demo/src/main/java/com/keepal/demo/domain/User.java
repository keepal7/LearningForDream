package com.keepal.demo.domain;

import com.keepal.demo.validator.Age;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class User {

    public interface Save { }

    public interface Update { }

    /**
     * 当是Save的时候要求为null
     * 当时Update的时候要求不为Null
     */
    @Null(groups = {Save.class})
    @NotNull(groups = {Update.class})
    private Long id;

    /**
     * 要求长度限制为2~20
     */
    @Size(min = 2, max = 20, groups = {Save.class, Update.class})
    private String name;

    /**
     * 要求在18~50之间
     */
//    @Size(min = 18, max = 50, groups = {Save.class, Update.class})
    // 自定义注解，实现自定义校验逻辑
    @Age(min = 10, max = 30, groups = {Save.class, Update.class})
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
