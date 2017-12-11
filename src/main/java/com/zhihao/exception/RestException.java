package com.zhihao.exception;

/**
 * Created by HT on 2017/12/5.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.zhihao.constant.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestException extends RuntimeException {
    protected Logger logger = LoggerFactory.getLogger(RestException.class);
    private Integer code = Integer.valueOf(-2);
    private String msg;
    private String error;

    public RestException(Exception e) {
        super(e.getMessage());
        this.logger.error("系统异常", e);
        e.printStackTrace();
        StringWriter swriter = new StringWriter();
        PrintWriter pwriter = new PrintWriter(swriter);
        e.printStackTrace(pwriter);
        pwriter.flush();
        swriter.flush();
        this.code = -99;
        this.msg = e.getMessage();
        this.error = swriter.toString();

        try {
            pwriter.close();
            swriter.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public RestException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RestException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RestException(Integer code, String msg, String error) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.error = error;
    }

    /*public RestException(ApiReturnCodeEnum returnCodeEnum) {
        super(returnCodeEnum.getDescription());
        this.code = Integer.valueOf(returnCodeEnum.getCode());
        this.msg = returnCodeEnum.getDescription();
    }*/

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Map<String, Object> asMap() {
        HashMap map = new HashMap();
        map.put("code", this.code);
        map.put("msg", this.msg);
        if(this.error != null) {
            map.put("error", this.error);
        }

        return map;
    }

    /*public String asString() {
        return FastJsonUtils.toString(this.asMap());
    }

    public boolean isError() {
        return this.code == RestStatus.ERROR.code;
    }*/
}