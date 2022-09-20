package com.abc.multi_module.system.controller;


import com.abc.multi_module.system.mapper.RoleMapper;
import com.abc.multi_module.system.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleMapper roleMapper;

    @GetMapping("/role/all")
    List<Role> all(){
        return roleMapper.all();
    }

    @GetMapping("/role/paging")
    List<Role> paging(){
        return roleMapper.paging();
    }

    @PostMapping("/role/insert")
    String insert(@RequestBody Role role){
        roleMapper.insert(role);
        return "inserted";
    }

    @PostMapping("/role/update/{name}/{id}")
    String update(@PathVariable(value = "name") String name, @PathVariable(value = "id") int id){
        roleMapper.update(name,id);
        return "name updated";
    }

    @PostMapping("/role/delete/{id}")
    String delete(@PathVariable(value = "id") int id){
        roleMapper.deleteById(id);
        return "deleted";
    }

}
