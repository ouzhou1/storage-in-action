package org.peterpark.storage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.peterpark.storage.model.BaseResponse;

import javax.servlet.http.HttpServletRequest;


/**
 * Description:
 *
 * @author: peter
 * @date: 2018/9/12.
 */

// @RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse globalException(HttpServletRequest request, Throwable ex) {
        return new BaseResponse(false, "其他异常", null);
    }
}
