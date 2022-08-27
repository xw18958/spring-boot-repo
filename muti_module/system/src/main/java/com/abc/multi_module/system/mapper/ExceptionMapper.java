package com.abc.multi_module.system.mapper;
import com.abc.logging.Logs;
import com.abc.multi_module.system.model.A;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ExceptionMapper {
    @Select("select * from sys_log")
    List<Logs> findAll();

    @Insert("insert into sys_log(log_type,time,description,method,exception_detail,create_time,request_ip) value(#{log_type}," +
            "#{time},#{description},#{method},#{exception_detail},#{createTime},#{requestIp})")
    void insert(Logs logs);
}
