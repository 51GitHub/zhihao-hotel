package com.zhihao.constant;

/**
 * Created by HT on 2017/12/5.
 */

import java.util.HashMap;
import java.util.Map;

public enum RestStatus {
    SUCCESS(Integer.valueOf(0)),
    ERROR(Integer.valueOf(-1)),
    UNAUTHORIZED(Integer.valueOf(401), "未授权访问"),
    FORBIDDEN(Integer.valueOf(403), "禁止访问"),
    NOT_FOUND(Integer.valueOf(404), "内容不存在"),
    SERVER_ERROR(Integer.valueOf(500), "服务器异常");

    Integer code;
    String msg;

    private RestStatus(Integer code) {
        this.code = code;
        switch(code.intValue()) {
            case -1:
                this.msg = "系统繁忙，请稍后再试";
                break;
            case 0:
                this.msg = "执行成功";
                break;
            default:
                this.msg = "系统未定义";
        }

    }

    private RestStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Map<String, Object> asMap() {
        HashMap map = new HashMap();
        map.put("code", this.code);
        map.put("msg", this.msg);
        return map;
    }

    public RestStatus setCode(Integer code) {
        this.code = code;
        return this;
    }

    public RestStatus setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /*public String asString() {
        return FastJsonUtils.toString(this.asMap());
    }

    public String toString() {
        return FastJsonUtils.toString(this.asMap());
    }*/
}
