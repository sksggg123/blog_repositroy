package com.sksggg123.blog.bootvue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentListController {

    @RequestMapping(value = "/main")
    public String main() {
        return "Main Page";
    }
}
