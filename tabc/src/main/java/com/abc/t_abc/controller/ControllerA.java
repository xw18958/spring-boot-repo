package com.abc.t_abc.controller;

import com.abc.t_abc.mapper.MapperA;
import com.abc.t_abc.model.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerA {
    @Autowired
    MapperA mapperA;

    @GetMapping("/a/all")
    List<A> findAll_A(){
        return mapperA.findAll();
    }

    @GetMapping("/a/rows")
    int rows(){
        return mapperA.rows();
    }

    @GetMapping("/a/fuzzy")
    List<A> fuzzy(){
        return mapperA.fuzzySearch();
    }

    @GetMapping("/a/sum")
    float sum(){
        return mapperA.aa_sum();
    }

    @PostMapping("/a/insert")
    String insert_A(@RequestBody A a){
            mapperA.insert(a);
            return "inserted";
    }

//    @GetMapping("/a/delete/{b}")
    @PostMapping("/a/delete")
//    String delete_A(@PathVariable String b){
    String delete_A(@RequestParam(name = "username") String b){
        mapperA.delete(b);
        return "deleted";
    }

    @PostMapping("/a/update")
    String update_A(@RequestParam(name="username") String name,@RequestParam(name="v") int v){
        mapperA.update(name,v);
        return "updated";
    }

}
