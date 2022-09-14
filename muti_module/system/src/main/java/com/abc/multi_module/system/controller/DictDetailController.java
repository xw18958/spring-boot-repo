package com.abc.multi_module.system.controller;

import com.abc.multi_module.system.mapper.DictDetailMapper;
import com.abc.multi_module.system.model.Dict;
import com.abc.multi_module.system.model.DictDetail;
import com.abc.multi_module.system.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictDetailController {
    @Autowired
    DictDetailMapper dictDetailMapper;

    @GetMapping("/dict_detail/hi")
    String hi(){
        return "hi";
    }

    @GetMapping("/dict_detail/all")
    List<DictDetail> all(){
        return dictDetailMapper.all();
    }

    @GetMapping("/dict_detail/paging")
    List<DictDetail> paging(){
        return dictDetailMapper.paging();
    }

    @PostMapping("/dict_detail/insert")
    String insert(@RequestBody DictDetail dictDetail){
        dictDetailMapper.insert(dictDetail);
        return "inserted";
    }

    @PostMapping("/dict_detail/update/{dictId}/{id}")
    String update(@PathVariable(value = "dictId") int dictId, @PathVariable(value = "id") int id){
        dictDetailMapper.update(dictId,id);
        return "menu name updated";
    }

    @PostMapping("/dict_detail/delete/{id}")
    String delete(@PathVariable(value = "id") int id){
        dictDetailMapper.deleteById(id);
        return "deleted";
    }

}
