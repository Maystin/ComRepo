package com.example.springboot.common;

import lombok.Data;

@Data
public class Result {           //通过result包装后台数据
    private static final String SUCCESS_CODE="200";
    private static final String ERROR_CODE="-1";
    private String code;        //接口的响应结果从code里面去体现
    private Object data;        //把后台数据存到result的data里面,前端所有接口都可以从这个result对象里面的data去拿数据
    private String msg;         //存放错误信息

    public static Result success() {
        Result result=new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    public static Result success(Object data) {
        Result result=new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    public static Result error(String msg) {
        Result result=new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }

    public static Result error(String code,String msg) {
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
