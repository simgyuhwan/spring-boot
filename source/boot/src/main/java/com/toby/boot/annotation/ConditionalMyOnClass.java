package com.toby.boot.annotation;

import com.toby.config.MyOnClassCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MyOnClassCondition.class)
public @interface ConditionalMyOnClass {
    String value();
}
