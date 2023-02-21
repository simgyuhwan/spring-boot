package com.toby.boot;

import com.toby.boot.service.SimpleHelloService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService indexService = new SimpleHelloService();

        String ret = indexService.sayHello("Sim");

        assertThat(ret).isEqualTo("Hello Sim");
    }

}
