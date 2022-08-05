package com.universe.demo.springboot.conditional;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ConfigTest {

    @ConditionalOnExpression("#{'true'==environment['config.myflag']?false:true}")
    @Bean
    public ConfigService configService(){
        return new ConfigService();
    }

}
