package com.muruoyi.springbootdemo.exception;

import com.muruoyi.springbootdemo.api.vo.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult ValidatedException(MethodArgumentNotValidException e, HttpServletRequest request){
        return ApiResult.fail("400",e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceException.class)
    public ApiResult ServiceException(ServiceException e, HttpServletRequest request){
        ServiceError error = e.getError();
        return ApiResult.fail(error.getCode(),error.getMessage());
    }
}
