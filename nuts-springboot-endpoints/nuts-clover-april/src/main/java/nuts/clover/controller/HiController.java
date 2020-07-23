package nuts.clover.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sleeber
 */
@RestController
public class HiController {

    @RequestMapping("/hi")
    public String sayHi(){
        return "hi gradle.";
    }

}
