package com.toby.boot.controller;

import com.toby.boot.service.SimpleIndexService;

import java.util.Objects;

public class IndexController {
    public String hello(String name) {
        SimpleIndexService simpleIndexService = new SimpleIndexService();
        return simpleIndexService.sayHello(Objects.requireNonNull(name));
    }
}
