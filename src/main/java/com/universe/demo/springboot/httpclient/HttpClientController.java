package com.universe.demo.springboot.httpclient;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

@Slf4j
@Controller
@RequestMapping("/http")
public class HttpClientController {
    //@ResponseBody
    @RequestMapping("/test")
    public Object test(PrintWriter printWriter) {
        try {
            printWriter.write("1\n");
            Thread.sleep(500);
            printWriter.write("2\n");
            printWriter.flush();
            Thread.sleep(500);
            printWriter.write("3\n");
            printWriter.flush();
            Thread.sleep(500);
            printWriter.write("4\n");
            printWriter.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "wahahaha";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public Object test2() {
        return "wahahaha";
    }
}
