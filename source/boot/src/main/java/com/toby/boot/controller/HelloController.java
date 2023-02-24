package com.toby.boot.controller;

import com.toby.boot.service.HelloService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    @GetMapping("/hello")
    public String hello(String name) {
        if(!StringUtils.hasText(name)) {
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(Objects.requireNonNull(name));
    }

}
