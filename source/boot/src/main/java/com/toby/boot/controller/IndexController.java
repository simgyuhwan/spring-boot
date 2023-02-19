package com.toby.boot.controller;

import com.toby.boot.service.IndexService;

import java.util.Objects;

public class IndexController {
    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    public String hello(String name) {
        return indexService.sayHello(Objects.requireNonNull(name));
    }
}
