package com.sda.springdemojavaee14.controller;

import com.sda.springdemojavaee14.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController creates new Spring bean base on the class
// bean = component = managed object (object created bt Spring for us)
//TODO: install postman :P
@RestController
public class MyFirstRestController {

    private static final Logger log = LoggerFactory.getLogger(MyFirstRestController.class);

    //@GetMapping means
    // - code of the method will be run when we hit endpoint
    // - we use exact HTTP method


    private final GreetingService greetingService;

    // dependecy injetion = providing required collaboratros/dependecies by Spring
    public MyFirstRestController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping("/say-hello")
    public String hello(){
        // TODO: explain logger level
        log.info("hello method was called..");

        return "Welcome to spring class ";
    }

    @PostMapping("/say-bye")
    public String bye(){
        log.info("byee method was called..");

        return "Bye User";
    }

    @GetMapping("/greeting")
    public String greetUser() {
        log.info("greetUser");

        return greetingService.makeSomeGreetingToUser("Kristaps");
    }
}
