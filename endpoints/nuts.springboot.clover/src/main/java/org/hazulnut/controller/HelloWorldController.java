package org.hazulnut.controller;

import org.hazulnut.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller usage example.
 *
 * <p> Demonstrate the call of controller.
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/23 18:36: created.<br>
 */
@RestController
@RequestMapping("/clover")
public class HelloWorldController {

    @RequestMapping("/sayHi")
    public String sayHello() {
        return "Hello World!";
    }

    @Autowired
    private Student student;

    @RequestMapping("/info")
    public String getInfo(){
        return student.toString();
    }
}
