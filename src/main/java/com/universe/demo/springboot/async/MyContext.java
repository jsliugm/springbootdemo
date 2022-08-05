package com.universe.demo.springboot.async;

public class MyContext {
    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void set(String v){
        threadLocal.set(v);
    }

    public static String get() {
        return threadLocal.get();
    }
}
