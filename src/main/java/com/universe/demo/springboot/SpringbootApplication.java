package com.universe.demo.springboot;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *
 * Created by jsliu on 2019/1/13.
 */
@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = "com.universe.demo.springboot.mapper")
@Slf4j
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        log.info("success ^V^");
    }
}
