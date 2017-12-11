package com.zhihao.web;

import com.zhihao.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by HT on 2017/12/5.
 */
@RestController
public class IndexController extends BaseRestController{
    @Value("${book.name}")
    private String name;
    @Value("${book.price}")
    private String price;

    @RequestMapping(value = "/test"/*, produces = { "application/json;charset=UTF-8" }*/)
    public HashMap getStr(){
        HashMap map=new HashMap();
        map.put("name",name);
        map.put("price",price);
        return map;
    }

    @RequestMapping(value = "/str", produces = { "application/json;charset=UTF-8" })
    public String str(){
        if(true){
            throw new RestException("我主动抛出了异常！");
        }
        return "陈智慧和";
    }
}
