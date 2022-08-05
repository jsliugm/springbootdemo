package com.universe.demo.springboot.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncContrller {
    @Autowired
    private AsyncServiceImpl asyncService;
    @RequestMapping("/first")
    public Object hello() {

        MyContext.set("aaa");
        System.out.println("contrller============"+ Thread.currentThread().getName());
        asyncService.asyncMethodWithVoidReturnType();
        asyncService.asyncMethodWithVoidReturnType2();
        return "hello world";
    }




}
