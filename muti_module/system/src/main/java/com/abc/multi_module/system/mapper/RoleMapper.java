package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from sys_role")
    List<Role> all();

    // 3 rows per page.
    @Select("select * from sys_role limit 3 offset 0")
    List<Role> paging();

    @Insert("insert into sys_role(role_id,name,level) values(#{roleId},#{name},#{level})")
    void insert(Role Role);

    @Update("update sys_role set name = #{name} where role_id = #{id}")
    void update(String name, int id);

    @Delete("delete from sys_role where role_id = #{id}")
    void deleteById(int id);

}
