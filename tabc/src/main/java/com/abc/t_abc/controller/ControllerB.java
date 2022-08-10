package com.abc.t_abc.controller;

import com.abc.t_abc.mapper.MapperB;
import com.abc.t_abc.model.A;
import com.abc.t_abc.model.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerB {
    @Autowired
    MapperB mapperB;

    @GetMapping("/b/all")
    List<A> findAll_A(){
        return mapperB.findAll();
    }

    @PostMapping("/b/insert")
    String insert_A(@RequestBody B b){
        mapperB.insert(b);
        return "inserted";
    }

    @PostMapping("/b/delete")
    String delete_A(@RequestParam(name = "username") String b){
        mapperB.delete(b);
        return "deleted";
    }

    @PostMapping("/b/update")
    String update_A(@RequestParam(name="username") String name,@RequestParam(name="v") int v){
        mapperB.update(name,v);
        return "updated";
    }
}
