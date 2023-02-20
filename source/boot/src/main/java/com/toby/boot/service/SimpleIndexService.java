package com.toby.boot.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleIndexService implements IndexService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
