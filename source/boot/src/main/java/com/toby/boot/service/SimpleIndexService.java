package com.toby.boot.service;

import com.toby.boot.annotation.MyComponent;
import org.springframework.stereotype.Component;

@MyComponent
public class SimpleIndexService implements IndexService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
