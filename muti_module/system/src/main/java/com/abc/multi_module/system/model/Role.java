package com.abc.multi_module.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    int roleId;
    String name;
    int level;
}
