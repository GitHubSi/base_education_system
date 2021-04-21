package henu.soft.xiaosi.exception;


import henu.soft.xiaosi.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.authc.ExpiredCredentialsException;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ExpiredCredentialsException.class)
    public ResultResponse handleException(ExpiredCredentialsException e){
        return ResultResponse.fail(401,"登录信息失效，请重新登录！",null);
    }
    @ExceptionHandler(Exception.class)
    public ResultResponse handleException(Exception e) {
        return ResultResponse.fail(500,"服务器繁忙，请稍后重试！",null);
    }



}
