package com.abc.t_abc.mapper;

import com.abc.t_abc.model.A;
import com.abc.t_abc.model.C;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MapperC {
    @Select("select * from C")
    List<C> findAll();

    @Select("select * from C where username like 'b%'")
    List<C> fuzzySearch();

    @Insert("insert into C(username,id,aa,correct_aa,bb,correct_bb) value(#{username},#{aaS},#{bbS})")
    void insert(C c);

    @Insert("insert into C(username,aaS,bbS) value('zxc',#{aas},10)")
    void insert_aas(float aas);

//    @Insert("insert into C value(?,?,#{bbs}) where username='zxc'")
//    void insert_bbs(float bbs);

    @Insert("insert into C(username,aaS,bbS) value('zxc',#{aas},#{bbs})")
    void insert_all(float aas, float bbs);

    @Delete("delete from C where username = #{name}")
    void delete(String name);

    @Update("update C set aaS = #{value} where username = #{name}")
    void update(String name, int value);
}
