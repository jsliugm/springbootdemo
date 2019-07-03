package com.universe.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jsliu on 2019/1/13.
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public Object hello(){
        return "test";
    }
    @RequestMapping("/test2")
    public Object hello2(){
        return "test2";
    }
}
