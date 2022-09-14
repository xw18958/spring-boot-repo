package com.abc.multi_module.system.controller;

import com.abc.multi_module.system.mapper.DeptMapper;
import com.abc.multi_module.system.model.Dept;
import com.abc.multi_module.system.model.DictDetail;
import com.abc.multi_module.system.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DeptMapper deptMapper;

    @GetMapping("/dept/hi")
    String hi(){
        return "hi";
    }

    @GetMapping("/dept/all")
    List<Dept> all(){
        return deptMapper.all();
    }

    @GetMapping("/dept/paging")
    List<Dept> paging(){
        return deptMapper.paging();
    }

    @PostMapping("/dept/insert")
    String insert(@RequestBody Dept dept){
        deptMapper.insert(dept);
        return "inserted";
    }

    @PostMapping("/dept/update/{name}/{id}")
    String update(@PathVariable(value = "name") String name, @PathVariable(value = "id") int id){
        deptMapper.update(name,id);
        return "menu name updated";
    }

    @PostMapping("/dept/delete/{id}")
    String delete(@PathVariable(value = "id") int id){
        deptMapper.deleteById(id);
        return "deleted";
    }

}
