package com.abc.t_abc.controller;

import com.abc.t_abc.mapper.MapperA;
import com.abc.t_abc.mapper.MapperB;
import com.abc.t_abc.mapper.MapperC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerC {
    @Autowired
    MapperB mapperB;
    @Autowired
    MapperA mapperA;
    @Autowired
    MapperC mapperC;

    @GetMapping("/c/aas")
    float aas(){
        float correctA = mapperB.correct_aa_sum();
        float a = mapperA.aa_sum();
        float aas = correctA/a;
        mapperC.insert_aas(aas);
        return aas;
    }

//    @GetMapping("/c/bbs")
//    float bbs(){
//        float correctB = mapperB.correct_bb_sum();
//        float b = mapperA.bb_sum();
//        float bbs = correctB/b;
//        mapperC.insert_bbs(bbs);
//        return bbs;
//    }

    @GetMapping("/c/insert_all")
    void insertAll(){
        float correctA = mapperB.correct_aa_sum();
        float a = mapperA.aa_sum();
        float aas = correctA/a;

        float correctB = mapperB.correct_bb_sum();
        float b = mapperA.bb_sum();
        float bbs = correctB/b;
        mapperC.insert_all(aas,bbs);
    }

    @PostMapping("/c/delete")
        String delete(@RequestParam(name = "username") String username){
        mapperC.delete(username);
        return "deleted";
        }

}
