package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select * from sys_menu")
    List<Menu> all();

    @Select("select menu_id from sys_menu where pid = #{id}")
    List<Integer> subIds(int id);

    @Select("select pid from sys_menu where menu_id = #{id}")
    int getParentId(int id);

    @Select("select * from sys_menu where pid = #{id} OR  menu_id = #{id}")
    List<Menu> subAndSiblingMenu(int id);

    @Insert("insert into sys_menu(menu_id,pid,name) values(#{menuId},#{parentId}" +
            ",#{name})")
    void insert(Menu menu);

    @Update("update sys_menu set name = #{name} where menu_id = #{id}")
    void update(String name, int id);

    @Delete("delete from sys_menu where menu_id = #{id}")
    void deleteById(int id);

}
