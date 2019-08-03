package org.ainy.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yuandong
 * @Description: Demo
 * @Date: 2019-08-01 16:40
 */
@RestController
@RequestMapping
public class DemoController {

    @GetMapping(value = "/demo")
    public String demo(@RequestParam(defaultValue = "WeChat") String name) {

        return "Hello World ! I am " + name;
    }
}
