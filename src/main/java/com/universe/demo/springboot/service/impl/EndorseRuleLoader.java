package com.universe.demo.springboot.service.impl;

import com.universe.demo.springboot.service.AbstractRuleLoader;
import org.springframework.stereotype.Service;

@Service
public class EndorseRuleLoader extends AbstractRuleLoader {
    @Override
    public void loader() {
        System.out.println("EndorseRuleLoader.loader()");
    }
}
