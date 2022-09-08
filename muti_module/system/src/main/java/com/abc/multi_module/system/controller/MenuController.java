package com.abc.multi_module.system.controller;

import com.abc.multi_module.system.mapper.MenuMapper;
import com.abc.multi_module.system.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuMapper menuMapper;

    @GetMapping("/menu/hi")
    String hi(){
        return "hi";
    }

    @GetMapping("/menu/all")
    List<Menu> all(){
        return menuMapper.all();
    }

    @PostMapping("/menu/insert")
    String insert(@RequestBody Menu menu){
        menuMapper.insert(menu);
        return "inserted";
    }

    @PostMapping("/menu/update/{name}/{id}")
    String update(@PathVariable(value = "name") String name,@PathVariable(value = "id") int id){
        menuMapper.update(name,id);
        return "menu name updated";
    }

    @PostMapping("/menu/sub_ids/{id}")
    List<Integer> subIds(@PathVariable(value = "id") int id){
        return menuMapper.subIds(id);
    }

    @PostMapping("/menu/sub_sibling_menu/{id}")
    List<Menu> subAndSiblingMenu(@PathVariable(value = "id") int id){
        int parentId = menuMapper.getParentId(id);
        return menuMapper.subAndSiblingMenu(parentId);
    }

    @PostMapping("/menu/delete/{id}")
    String delete(@PathVariable(value = "id") int id){
        menuMapper.deleteById(id);
        return "deleted";
    }

}
