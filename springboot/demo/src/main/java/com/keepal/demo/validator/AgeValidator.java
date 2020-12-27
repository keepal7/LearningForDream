package com.keepal.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 实现对应的接口
 * 重写对应的函数，实现自定义校验器
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private Integer max;
    private Integer min;

    @Override
    public void initialize(Age age) {
        this.max = age.max();
        this.min = age.min();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value < max && value > min;
    }
}
