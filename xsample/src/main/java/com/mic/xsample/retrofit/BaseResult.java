package com.mic.xsample.retrofit;


import java.util.HashMap;

/**
 * Created by hcDarren on 2017/12/16.
 */

public class BaseResult {

    String code;
    String msg;

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public boolean isOk(){
        return "0000".equals(code);
    }
}
