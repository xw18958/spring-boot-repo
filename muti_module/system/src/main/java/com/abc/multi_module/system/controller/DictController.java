package com.abc.multi_module.system.controller;

import com.abc.multi_module.system.mapper.DictMapper;
import com.abc.multi_module.system.model.Dict;
import com.abc.multi_module.system.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictController {
    @Autowired
    DictMapper dictMapper;

    @GetMapping("/dict/hi")
    String hi(){
        return "hi";
    }

    @GetMapping("/dict/all")
    List<Dict> all(){
        return dictMapper.all();
    }

    @GetMapping("/dict/paging")
    List<Dict> paging(){
        return dictMapper.paging();
    }

    @PostMapping("/dict/insert")
    String insert(@RequestBody Dict dict){
        dictMapper.insert(dict);
        return "inserted";
    }

    @PostMapping("/dict/update/{name}/{id}")
    String update(@PathVariable(value = "name") String name, @PathVariable(value = "id") int id){
        dictMapper.update(name,id);
        return "menu name updated";
    }

    @PostMapping("/dict/delete/{id}")
    String delete(@PathVariable(value = "id") int id){
        dictMapper.deleteById(id);
        return "deleted";
    }

}
