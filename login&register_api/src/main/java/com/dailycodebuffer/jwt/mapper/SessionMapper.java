package com.dailycodebuffer.jwt.mapper;

import com.dailycodebuffer.jwt.model.Session;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SessionMapper {
    @Select("select * from session")
    List<Session> findAll();

    @Insert("insert into session(code,msg,data) values(#{code},#{msg},#{data})")
//    @Insert("insert into session(code,msg) values(#{code},#{msg}")
    void insert(Session session);
}
