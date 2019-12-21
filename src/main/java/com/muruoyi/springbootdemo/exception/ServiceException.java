package com.muruoyi.springbootdemo.exception;

public class ServiceException extends RuntimeException {

    private ServiceError error;

    public ServiceException() {
        this.error = ServiceError.CommonError;
    }

    public ServiceException(ServiceError error) {
        this.error = error;
    }

    public ServiceError getError() {
        return error;
    }

    public void setError(ServiceError error) {
        this.error = error;
    }
}
