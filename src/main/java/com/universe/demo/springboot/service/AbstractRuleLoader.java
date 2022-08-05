package com.universe.demo.springboot.service;

import javax.annotation.PostConstruct;

public abstract class AbstractRuleLoader implements RuleLoader {
    @PostConstruct
    private void init() {
        loader();
    }
}
