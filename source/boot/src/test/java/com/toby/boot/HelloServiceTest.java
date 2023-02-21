package com.toby.boot;

import com.toby.boot.service.HelloDecorator;
import com.toby.boot.service.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest{}

public class HelloServiceTest {

    @UnitTest
    void simpleHelloService() {
        SimpleHelloService indexService = new SimpleHelloService();

        String ret = indexService.sayHello("Sim");

        assertThat(ret).isEqualTo("Hello Sim");
    }

    @FastUnitTest
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        String name = helloDecorator.sayHello("name");

        Assertions.assertThat(name).isEqualTo("*name*");
    }

}
