package com.example.testApiPage.model;

public class ResponseParam {
    private String retCode;
    private RetData retData;

    public ResponseParam(){}
    public boolean isSuccess(){
        if(retCode.equals("0000")) return true;
        else return false;
    }
}
