package com.muruoyi.springbootdemo.exception;

public enum ServiceError {
    CommonError("ERR-0001","Common Error"),
    TitleCanNotBeTom("ERR-0002","title can not be tom"),
    CanNotFindMember("ERR-0003","查无此人");

    private String code;

    private String message;

    ServiceError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
