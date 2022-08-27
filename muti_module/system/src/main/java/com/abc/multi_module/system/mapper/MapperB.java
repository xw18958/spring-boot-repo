package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.A;
import com.abc.multi_module.system.model.B;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MapperB {
    @Select("select * from B")
    List<A> findAll();
    @Select("select sum(correct_aa) from B")
    float correct_aa_sum();
    @Select("select sum(correct_bb) from B")
    float correct_bb_sum();
    @Insert("insert into B(username,id,aa,correct_aa,bb,correct_bb) value(#{username},#{id},#{aa},#{correct_aa},#{bb},#{correct_bb})")
    void insert(B b);

    @Delete("delete from B where username = #{name}")
    void delete(String name);

    @Update("update B set aa = #{value} where username = #{name}")
    void update(String name, int value);
}
