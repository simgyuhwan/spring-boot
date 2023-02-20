package com.toby.boot.controller;

import com.toby.boot.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class IndexController {
    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return indexService.sayHello(Objects.requireNonNull(name));
    }

}
