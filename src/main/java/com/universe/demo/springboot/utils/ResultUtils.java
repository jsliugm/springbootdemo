package com.universe.demo.springboot.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ResultUtils {
    public static Object success(String msg) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("success", "true");
        resultMap.put("msg", msg);
        return resultMap;
    }

    public static Object error(String msg) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("success", "false");
        resultMap.put("msg", msg);
        return resultMap;
    }
}
