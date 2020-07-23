package org.hazulnut;

import org.hazulnut.sdf.DeveloperProperty1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * <p>
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/23 15:29: created.<br>
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    DeveloperProperty1 developerProperty;

    @RequestMapping("/get")
    public String getJson() {
        return developerProperty.toString();
        //return "hello";
    }
}
