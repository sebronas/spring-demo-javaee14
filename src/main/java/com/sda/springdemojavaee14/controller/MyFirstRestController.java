package com.sda.springdemojavaee14.controller;

import com.sda.springdemojavaee14.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController creates new Spring bean base on the class
// bean = component = managed object (object created bt Spring for us)

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
        log.info("hello method was called..");

        return "Welcome to spring class ";
    }

    // example query link from google:
    // https://www.google.com/search?q=Latvia

    // server: https://www.google.com
    // /search: application (endpoint) on the server
    // ? : query seperator
    // q=Latvia, q: parameter name, Latvia i value for q parameter
    // & is used if more parameters are coming

    // /greeting?firstName=Kristaps&surname=Sebris
    @PostMapping("/say-bye")
    public String bye(){
        log.info("byee method was called..");

        return "Bye User";
    }

    @GetMapping("/greeting")
    public String greetUser(@RequestParam(value = "name", defaultValue = "Janis") String firstName,
                            @RequestParam(value = "surname", defaultValue = "Berzins") String surname) {
        log.info("greetUser called with params: name: [{}], surname[{}]", firstName, surname); //  == String.format("...");

        return greetingService.makeSomeGreetingToUser(firstName + " " + surname);
    }


}
