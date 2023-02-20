package com.toby.boot.service;

import org.springframework.stereotype.Component;

@Component
public class SimpleIndexService implements IndexService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
