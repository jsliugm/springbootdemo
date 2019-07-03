package com.universe.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jsliu on 2019/1/13.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Object hello(){
        return "hello world";
    }
    @RequestMapping("/hello2")
    public Object hello2(){
        return "hello2";
    }
}
