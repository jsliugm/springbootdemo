package com.universe.demo.springboot.excepiton;

import com.universe.demo.springboot.utils.ResultUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        String errorMessage = "参数校验失败";
 
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage += ", " + fieldError.getDefaultMessage();
        }
        //JSONMessageResponse error = SystemResultUtil.error(5006, errorMessage);
        return new ResponseEntity<>(ResultUtils.error(errorMessage), HttpStatus.BAD_REQUEST);
    }
}