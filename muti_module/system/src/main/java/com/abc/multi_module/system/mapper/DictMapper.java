package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.Dept;
import com.abc.multi_module.system.model.Dict;
import com.abc.multi_module.system.model.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DictMapper {
    @Select("select * from sys_dict")
    List<Dict> all();


    //from index 0 to index 1
//    @Select("select * from sys_dict limit 1,2")
//    List<Dict> paging();

    // 3 rows per page.
    @Select("select * from sys_dict limit 3 offset 0")
    List<Dict> paging();

    @Insert("insert into sys_dict(dict_id,name) values(#{dictId},#{name})")
    void insert(Dict dict);

    @Update("update sys_dict set name = #{name} where dict_id = #{id}")
    void update(String name, int id);

    @Delete("delete from sys_dict where dict_id = #{id}")
    void deleteById(int id);
}
