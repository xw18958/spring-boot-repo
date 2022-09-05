package com.abc.multi_module.system.handler;

import com.abc.GlobalException;
import com.abc.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    public @ResponseBody Result globalExceptionHandler(GlobalException e){
        Result res = new Result();
        res.setCode(e.getCode());
        res.setMsg(e.getMsg());
        res.setProceeded(e.getIsProceeded());
        return res;
    }

}
