package com.abc.multi_module.system;

import com.abc.GlobalException;
import com.abc.logging.Logs;
import com.abc.multi_module.system.mapper.ExceptionMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.abc.multi_module.system.controller..*(..))")
//@Pointcut("@annotation(OperationLog)")
    public void logPointCut(){};

    @Autowired
    ExceptionMapper exceptionMapper;

    LocalDateTime startingTime;

    @Before("logPointCut()")
    public void beforeRunning(){
        startingTime = LocalDateTime.now();
    }

    @Around("logPointCut()")
    public Object exception(ProceedingJoinPoint pjp) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        try{
            Object obj = pjp.proceed();
            System.out.println("cool");
            return obj;
        }catch(Exception e){
            System.out.println("e:"+e.getClass());
            System.out.println("e2:"+e.getMessage());
            LocalDateTime.now();
            Logs logs = new Logs();
            logs.setLog_type("error");
            logs.setDescription(e.getClass().getName());
            logs.setMethod(request.getMethod());
            LocalDateTime endingTime = LocalDateTime.now();
            Long runtime = ChronoUnit.MILLIS.between(startingTime, endingTime);
            logs.setTime(runtime);
            logs.setRequestIp(request.getServerName());
            logs.setException_detail(e.getMessage());
            logs.setCreateTime(LocalDateTime.now());
            exceptionMapper.insert(logs);
            throw new GlobalException();
        }
    }

//    @Around("logPointCut()")
//    public void exception2(ProceedingJoinPoint pjp) throws Throwable{
//        try{
//            Object obj = pjp.proceed();
//            System.out.println("cool");
//        }catch (Exception e){
//            System.out.println("33333333333");
//            System.out.println("e:"+e.getClass());
//            System.out.println("00000000");
//        }
//    }

//    @AfterReturning("logPointCut()")
//    public void ok() {
//        System.out.println("ok!");
//    }



}
