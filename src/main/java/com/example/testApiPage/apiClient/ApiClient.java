package com.example.testApiPage.apiClient;

import com.example.testApiPage.apiClient.strategy.savingResponse.SavingResponse;
import com.example.testApiPage.apiClient.strategy.settingRequest.SettingRequest;
import com.example.testApiPage.model.RequestParam;
import com.example.testApiPage.model.ResponseParam;

public abstract class ApiClient {

    public RequestParam requestParam;
    public ResponseParam responseParam;

    // 전략 패턴
    public SettingRequest settingRequest;
    public SavingResponse savingResponse;

    public ApiClient(SettingRequest settingRequest, SavingResponse savingResponse){
        this.settingRequest = settingRequest;
        this.savingResponse = savingResponse;
    }

    public abstract ResponseParam callApi();

}
