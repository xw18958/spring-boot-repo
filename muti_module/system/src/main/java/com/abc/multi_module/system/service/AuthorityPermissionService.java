package com.abc.multi_module.system.service;

import org.springframework.stereotype.Service;

import static com.abc.utils.StringUtility.isEmpty;

@Service("aps")
public class AuthorityPermissionService {
    public boolean hasPermission(String permissions) {
        if (isEmpty(permissions)) {
            return false;
        } else return true;
    }
}
