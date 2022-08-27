package com.abc.logging;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;

//记录接口的操作日志
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface OperationLog {

}

