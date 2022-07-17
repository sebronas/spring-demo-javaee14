package com.sda.springdemojavaee14.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MyFirstWebController {

    //web controller always returns String
    // This string is name og html page
    // /page-page?name=kristaps
    // model will be available on html template

    @GetMapping("/my-page")
    public String myFirstSpringWebPage(@RequestParam("name") String myName,
                                       Model parametersForTemplate) {
        log.info("my First SPRING WEB PAGE");
        log.info("Recived name [{}]", myName);
        parametersForTemplate.addAttribute("name", myName);


        return "my-first-web-page";
    }

}
