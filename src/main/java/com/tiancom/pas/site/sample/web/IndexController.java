package com.tiancom.pas.site.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String hello() {
        return "hello, db";
    }

    @GetMapping("/content")
    public String content() {
        return "content";
    }
}
