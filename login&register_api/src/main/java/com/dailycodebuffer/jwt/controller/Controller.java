package com.dailycodebuffer.jwt.controller;

import com.dailycodebuffer.jwt.mapper.SessionMapper;
import com.dailycodebuffer.jwt.mapper.UsersMapper;
import com.dailycodebuffer.jwt.model.JwtRequest;
import com.dailycodebuffer.jwt.model.JwtResponse;
import com.dailycodebuffer.jwt.model.Session;
import com.dailycodebuffer.jwt.model.Users;
import com.dailycodebuffer.jwt.service.UserService;
import com.dailycodebuffer.jwt.utility.JWTUtility;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Data
@RestController
public class Controller {
    @Autowired
    UsersMapper usersMapper;

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @GetMapping("/allSession")
    public List<Session> allSession() {
        return sessionMapper.findAll();
    }

    //register for an account.
    @PostMapping(value = "/register")
    private List<Users> register(@RequestBody Users users) {

        Session session = new Session();

        if (usersMapper.userExistance(users)==null){
            usersMapper.insert(users);
            session.setCode(0);
            session.setMsg("registration succeed");
        }else{
            session.setCode(-1);
            session.setMsg("username already exist");
        }
        session.setData(users.getUsername());
        sessionMapper.insert(session);
        return usersMapper.findAll();
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
