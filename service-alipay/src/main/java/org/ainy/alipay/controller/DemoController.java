package org.ainy.alipay.controller;

import lombok.extern.slf4j.Slf4j;
import org.ainy.alipay.service.StudentService;
import org.ainy.db.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author AINY
 * @description Demo
 * @date 2019-08-01 16:32
 */
@Slf4j
@RestController
@RequestMapping
public class DemoController {

    private final StudentService studentService;

    @Autowired
    public DemoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/demo")
    public String demo(@RequestParam(defaultValue = "Alipay") String name) {

        List<Student> list = studentService.getAll();

        log.info("list--->{}", list);

        return "Hello World ! I am " + name;
    }
}
