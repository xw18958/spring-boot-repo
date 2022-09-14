package com.abc.multi_module.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ipadController {

    String c = "";

    @GetMapping("/ipad/{command}")
    String run(@PathVariable (value = "command") String command){
        c = command;
        return "sent!";
    }

    @GetMapping("/ipad")
    String run2(){
        return c;
    }

}
