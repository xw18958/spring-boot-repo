package com.abc.multi_module.system.mapper;

import com.abc.multi_module.system.model.Dept;
import com.abc.multi_module.system.model.Dict;
import com.abc.multi_module.system.model.DictDetail;
import com.abc.multi_module.system.model.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DictDetailMapper {
    @Select("select * from sys_dict_detail")
    List<DictDetail> all();

    // 3 rows per page.
    @Select("select * from sys_dict_detail limit 3 offset 0")
    List<DictDetail> paging();

    @Insert("insert into sys_dict_detail(detail_id,dict_id) values(#{detailId},#{dictId})")
    void insert(DictDetail dictDetail);

    @Update("update sys_dict_detail set dict_id = #{dictId} where detail_id = #{id}")
    void update(int dictId, int id);

    @Delete("delete from sys_dict_detail where detail_id = #{id}")
    void deleteById(int id);
}
