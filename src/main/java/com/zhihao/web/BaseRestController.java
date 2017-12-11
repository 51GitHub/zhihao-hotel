package com.zhihao.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.zhihao.exception.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public  class BaseRestController {
    @Autowired(
            required = false
    )

    private static final Map<String,String> msgMap = new HashMap<>();
    /**
     * 自定义异常处理
     */
    @ExceptionHandler(RestException.class)
    public Map<String,String> handleRestException(RestException e){
        e.printStackTrace();
        msgMap.put("msg",e.getMessage());
        return msgMap;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public RestException processApiException(MethodArgumentNotValidException e) {
        ArrayList msgList = new ArrayList();
        Iterator var3 = e.getBindingResult().getAllErrors().iterator();

        while(var3.hasNext()) {
            ObjectError objectError = (ObjectError)var3.next();
            msgList.add(objectError.getDefaultMessage());
        }

        return new RestException(msgList.toString());
    }

    @ExceptionHandler({BindException.class})
    public RestException doBindException(BindException e) {
        ArrayList msgList = new ArrayList();
        Iterator var3 = e.getBindingResult().getAllErrors().iterator();

        while(var3.hasNext()) {
            ObjectError objectError = (ObjectError)var3.next();
            msgList.add(objectError.getDefaultMessage());
        }

        return new RestException((msgList.toString()));
    }

    @ExceptionHandler({Exception.class})
    public RestException processException(Exception e) {
        return new RestException(e);
    }
}

