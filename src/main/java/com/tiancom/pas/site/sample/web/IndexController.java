package com.tiancom.pas.site.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

//    @GetMapping("/")
//    public String hello() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserPrincipal) {
//            return "hello, " + ((UserPrincipal) principal).getUsername();
//        }
//        return "hello, 陌生人";
//    }

    @GetMapping("/content")
    public String content() {
        return "content";
    }
}
