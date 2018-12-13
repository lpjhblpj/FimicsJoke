package com.mic.xsample.rxretrofit;


public class ErrorHandle {

    public static class ServiceError extends Throwable{
        String errorCode;
        public ServiceError(String errorCode, String errorMsg) {
            super(errorMsg);
            this.errorCode = errorCode;
        }
    }
}
