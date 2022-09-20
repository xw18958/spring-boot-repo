package com.abc.multi_module.system.controller;

import com.abc.GlobalException;
import com.abc.logging.Logs;
import com.abc.logging.OperationLog;
import com.abc.multi_module.system.mapper.ExceptionMapper;
import com.abc.multi_module.system.mapper.MapperA;
import com.abc.multi_module.system.mapper.UsersMapper;
import com.abc.multi_module.system.model.*;
import com.abc.multi_module.system.respository.VerificationDao;
import com.abc.multi_module.system.security.JWTUtility;
import com.abc.multi_module.system.security.SecurityUtils;
import com.abc.multi_module.system.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    MapperA mapperA;
    @Autowired
    ExceptionMapper exceptionMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    VerificationDao verificationDao;

    @Autowired
    SecurityUtils securityUtils;

    @OperationLog
    @GetMapping("/")
    String hello(){
        int i = (int)(Math.random()*10000);
        return  String.valueOf(i);
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        //verification code stored in redis.
        String code;
        try{
            code = verificationDao.findCodeByKey(jwtRequest.getUsername()).getCode();
        }catch(BadCredentialsException e){
            throw new Exception("The username has no code in redis server", e);
        }

//        code = verificationDao.findCodeByKey(jwtRequest.getUsername()).getCode();

        //verifying the verification code
        if (!jwtRequest.getCode().equals(code)){
            GlobalException e = new GlobalException(1,"Wrong verification code!",false);
            throw e;
//            return new JwtResponse("wrong code!");
        };

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

    @GetMapping("/authUser")
    String userInfo(){
        String s = securityUtils.getActiveAccount();
        return s;
    }

    @PreAuthorize("@aps.hasPermission('123')")
    @PostMapping(value = "/register")
    public String register(@RequestBody SysUser user) {

        if (usersMapper.userExistance(user)==null){
            usersMapper.insert(user);
        }else return "username already exist.";

        return "registration succeed!";
    }

    @GetMapping("/ver/all")
    public List<Verification> getAllProducts() {
        return verificationDao.findAll();
    }

    @PostMapping("/ver/save")
    public Verification save(@RequestBody Verification v) {
        return verificationDao.save(v);
    }

    @PostMapping("/ver/getCode")
    public Verification getVerCode(@RequestBody String username) {
        int i = (int)(Math.random()*10000);
        String code = String.valueOf(i);
        Verification v = new Verification(code,username);
        return verificationDao.save(v);
    }

    @PostMapping("/ver/delete")
    public String deleteCode(@RequestBody String username) {
        return verificationDao.delete(username);
    }

    @PostMapping(value = "/user/insert")
    String userInsert(@RequestBody SysUser user){
        usersMapper.insert(user);
        return "inserted!";
    }

    @PostMapping("/user/update/{password}/{username}")
    String updateUserPassword(@PathVariable(value = "password") String password, @PathVariable(value = "username") String username){
        usersMapper.update(password,username);
        return "Password updated.";
    }

    @GetMapping("/sys_users")
    List<SysUser> sysUsers(){
        return usersMapper.findAll();
    }

    @GetMapping("/user/paging")
    List<SysUser> paging(){
        return usersMapper.paging();
    }

    @GetMapping("/exception/all")
    List<Logs> exceptions(){
        return exceptionMapper.findAll();
    }

    @GetMapping("/a/rows")
    int rows(){
//        Logger logger = LoggerFactory.getLogger(Controller.class);
//        logger.info("222222");
//        System.out.println("33333333");
        return mapperA.rows();
    }

    @GetMapping("/a/all")
    List<A> findAll_A(){
        return mapperA.findAll();
    }

    @PostMapping("/a/insert")
    String insert_A(@RequestBody A a){
        mapperA.insert(a);
        return "inserted";
    }

    @GetMapping("/glb")
    public void globalException(){
        throw new GlobalException(500,"glb exception!!!",true);
    }

    String a(){
        return "111";
    }
    @GetMapping("/gla")
    public String one(){
        return a();
    }
}
