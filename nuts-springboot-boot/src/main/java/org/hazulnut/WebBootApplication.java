package org.hazulnut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The project boot class.
 *
 * <p>Responsible for starting the boot project
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.0.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/21 16:36: created.<br>
 */
@SpringBootApplication
public class WebBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBootApplication.class, args);
    }
}
