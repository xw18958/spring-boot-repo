package com.abc.multi_module.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Menu {
    int menuId;
    int parentId;
    String name;

}
