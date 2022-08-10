package com.abc.t_abc.mapper;

import com.abc.t_abc.model.A;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MapperA {
    @Select("select * from A")
    List<A> findAll();
    @Select("select * from A where username like 'b%'")
    List<A> fuzzySearch();
    @Select("select sum(aa) from A")
    float aa_sum();
    @Select("select sum(bb) from A")
    float bb_sum();
    @Insert("insert into A(username,aa,bb) value(#{username},#{aa},#{bb})")
    void insert(A a);

    @Delete("delete from A where username = #{a}")
    void delete(String a);

    @Update("update A set aa = #{aavalue} where username = #{name}")
    void update(String name, int aavalue);
}
