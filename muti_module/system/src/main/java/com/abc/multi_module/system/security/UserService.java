package com.abc.multi_module.system.security;

import com.abc.multi_module.system.mapper.UsersMapper;
import com.abc.multi_module.system.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Logic to get the user form the Database
        SysUser sysUser = usersMapper.userExistance(new SysUser(userName,"0"));
//        return new User("admin","password0",new ArrayList<>());
        return new User(sysUser.getUsername(), sysUser.getPassword(),new ArrayList<>());
    }
}
