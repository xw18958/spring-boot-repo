package com.abc.multi_module.system.security;

import com.abc.multi_module.system.model.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {
    public Authentication getActiveAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * get current user
     */
    public SysUser getActiveUser() {
        return (SysUser) getActiveAuthentication().getPrincipal();
    }

    public String getActiveAccount(){
//        return getActiveUser().getUsername();
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
