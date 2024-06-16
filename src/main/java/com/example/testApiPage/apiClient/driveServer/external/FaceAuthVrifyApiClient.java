package com.example.testApiPage.apiClient.driveServer.external;

import com.example.testApiPage.apiClient.ApiClient;
import com.example.testApiPage.apiClient.strategy.savingResponse.SavingResponse;
import com.example.testApiPage.apiClient.strategy.settingRequest.SettingRequest;
import com.example.testApiPage.model.ResponseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FaceAuthVrifyApiClient extends ApiClient {
    @Autowired
    public FaceAuthVrifyApiClient(SettingRequest settingRequest, SavingResponse savingResponse) {
        super(settingRequest, savingResponse);
    }

    @Override
    public ResponseParam callApi() {
        // 호출...
        return null;
    }
}
