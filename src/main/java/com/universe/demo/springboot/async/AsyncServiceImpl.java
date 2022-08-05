package com.universe.demo.springboot.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncServiceImpl {
    @Async("myAsync")
    public void asyncMethodWithVoidReturnType() {
        log.info("asyncMethodWithVoidReturnType没有返回值的Async方法, ThreadName : {}", Thread.currentThread().getName());
        log.info("asyncMethodWithVoidReturnType get : {}", MyContext.get());
    }
    public void asyncMethodWithVoidReturnType2() {
        log.info("asyncMethodWithVoidReturnType2没有返回值的Async方法, ThreadName : {}", Thread.currentThread().getName());
        log.info("asyncMethodWithVoidReturnType2 get : {}", MyContext.get());

    }
}
