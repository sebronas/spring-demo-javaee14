package com.sda.springdemojavaee14.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j // provide log field for us
//the same as private static final Logger log = LoggerFactory.getLogger(MyFirstRestController.
public class GreetingService {


    public String makeSomeGreetingToUser(String name) {
        String result = "Welcome to Spring class " + name;

        log.info(result); // thanks of @Slf4j, we can just use this from MyFirstRestController.java file
        return result;
    }
}
