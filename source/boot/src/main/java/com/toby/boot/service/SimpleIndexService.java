package com.toby.boot.service;

public class SimpleIndexService implements IndexService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
