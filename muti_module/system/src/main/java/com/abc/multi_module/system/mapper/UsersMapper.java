package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.Dept;
import com.abc.multi_module.system.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from sys_users")
    List<SysUser> findAll();

@Select("select * from sys_users limit 3 offset 0")
    List<SysUser> paging();

    @Insert("insert into sys_users(username,password) values(#{username},#{password})")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
//            before = false, resultType = Integer.class)
    void insert(SysUser sysUser);

    @Delete("delete from sys_users where username=#{username}")
    void delete(SysUser sysUser);

    @Update("update sys_users set password = #{password} where username = #{username}")
    void update(String password, String username);
    @Select("select * from user where username = #{username} AND password = #{password}")
    SysUser userQuery(SysUser sysUser);

    @Select("select * from sys_users where username = #{username}")
    SysUser userExistance(SysUser sysUser);


}
