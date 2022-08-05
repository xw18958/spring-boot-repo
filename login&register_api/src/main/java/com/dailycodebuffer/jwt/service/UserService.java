package com.dailycodebuffer.jwt.service;

import com.dailycodebuffer.jwt.mapper.UsersMapper;
import com.dailycodebuffer.jwt.model.Users;
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
        Users user = usersMapper.userExistance(new Users(userName,"0"));

//        return new User("admin","password0",new ArrayList<>());
        return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }
}
