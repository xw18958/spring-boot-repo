package com.abc.multi_module.system.controller;

import com.abc.GlobalException;
import com.abc.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    String hello(){
        return "hello!";
    }


    @GetMapping("/glb")
    public void globalException(){
        throw new GlobalException(500,"glb exception!!!",true);
    }

    String a(){
        return "111";
    }
    @GetMapping("/gla")
    public String one(){
        return a();
    }
}
