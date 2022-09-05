package com.dailycodebuffer.jwt.mapper;

import com.dailycodebuffer.jwt.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(username,password) values(#{username},#{password})")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
//            before = false, resultType = Integer.class)
    void insert(Users users);

    @Delete("delete from users where username=#{username}")
    void delete(Users user);
    @Select("select * from users where username = #{username} AND password = #{password}")
    Users userQuery(Users users);

//    @Select("select * from users where username = #{username}")
@Select("select * from sys_users where username = #{username}")
    Users userExistance(Users users);

//    @Select("select * from users where username = #{username}")
//    Users findByUsername(Users users);

}
