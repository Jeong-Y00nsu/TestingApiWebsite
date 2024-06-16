package com.example.testApiPage.apiClient.strategy.settingRequest;

import com.example.testApiPage.model.RequestParam;
import com.example.testApiPage.model.ServiceModel;
import org.springframework.stereotype.Component;

@Component
public class SettingRequestForFaceAuth implements SettingRequest{
    @Override
    public void settingRequest(ServiceModel serviceModel, RequestParam requestParam) {
        // api 호출 전 request 파라미터 세팅
    }
}
