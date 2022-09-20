package com.abc.multi_module.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SysUser {
    @Id
    int id;
    String username;
    String password;

    public SysUser(String username, String password){
        this.username = username;
        this.password = password;
    }
}
