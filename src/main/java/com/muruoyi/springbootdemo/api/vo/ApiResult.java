package com.muruoyi.springbootdemo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {

    private boolean success = false;
    private String code;
    private String msg;
    private Object data;

    public static ApiResult success(String code,String msg,Object data){
        return ApiResult.builder().success(true).code(code).msg(msg).data(data).build();
    }

    public static ApiResult success(Object data){
        return ApiResult.builder().success(true).code("200").msg("success").data(data).build();
    }

    public static ApiResult fail(String code,String msg){
        return ApiResult.builder().code(code).msg(msg).build();
    }
}
