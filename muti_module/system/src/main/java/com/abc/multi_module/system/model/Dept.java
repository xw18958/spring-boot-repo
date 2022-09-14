package com.abc.multi_module.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dept {
    int deptId;
    int pId;
    String name;
}
