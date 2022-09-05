package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.SysUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from sys_users")
    List<SysUser> findAll();

    @Insert("insert into sys_users(username,password) values(#{username},#{password})")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
//            before = false, resultType = Integer.class)
    void insert(SysUser sysUser);

    @Delete("delete from user where username=#{username}")
    void delete(SysUser sysUser);
    @Select("select * from user where username = #{username} AND password = #{password}")
    SysUser userQuery(SysUser sysUser);

    @Select("select * from sys_users where username = #{username}")
    SysUser userExistance(SysUser sysUser);


}
