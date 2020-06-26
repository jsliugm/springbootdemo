package com.universe.demo.springboot.controller;

import com.universe.demo.springboot.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jsliu on 2019/1/13.
 */
@RestController
@Slf4j
public class HelloController {
    @RequestMapping("/hello")
    public Object hello() {
        return "hello world";
    }

    @RequestMapping("/hello2")
    public Object hello2() {
        return "hello2";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public Object hello3(@RequestBody String abc) {
        log.info(abc);
        return "hello3";
    }

    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    public Object hello4(@RequestBody PersonDto personDto) {
        log.info(personDto.getName());
        return "hello4";
    }
}
