package com.abc.multi_module.system.controller;

import com.abc.GlobalException;
import com.abc.logging.Logs;
import com.abc.logging.OperationLog;
import com.abc.multi_module.system.mapper.ExceptionMapper;
import com.abc.multi_module.system.mapper.MapperA;
import com.abc.multi_module.system.model.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    MapperA mapperA;
    @Autowired
    ExceptionMapper exceptionMapper;

    @OperationLog
    @GetMapping("/")
    String hello(){
        return "hello!";
    }

    @GetMapping("/exception/all")
    List<Logs> exceptions(){
        return exceptionMapper.findAll();
    }

    @GetMapping("/a/rows")
    int rows(){
//        Logger logger = LoggerFactory.getLogger(Controller.class);
//        logger.info("222222");
//        System.out.println("33333333");
        return mapperA.rows();
    }

    @GetMapping("/a/all")
    List<A> findAll_A(){
        return mapperA.findAll();
    }

    @PostMapping("/a/insert")
    String insert_A(@RequestBody A a){
        mapperA.insert(a);
        return "inserted";
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
