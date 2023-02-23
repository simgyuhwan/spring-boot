package com.toby.boot.annotation;

import com.toby.config.EnableMyAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Configuration
@ComponentScan
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}
