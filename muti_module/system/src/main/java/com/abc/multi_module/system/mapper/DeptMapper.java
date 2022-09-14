package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.Dept;
import com.abc.multi_module.system.model.Dict;
import com.abc.multi_module.system.model.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from sys_dept")
    List<Dept> all();

    // 3 rows per page.
    @Select("select * from sys_dept limit 3 offset 0")
    List<Dept> paging();

    @Insert("insert into sys_dept(dept_id,pid,name) values(#{deptId},#{pId},#{name})")
    void insert(Dept dept);

    @Update("update sys_dept set name = #{name} where dept_id = #{id}")
    void update(String name, int id);

    @Delete("delete from sys_dept where dept_id = #{id}")
    void deleteById(int id);
}
