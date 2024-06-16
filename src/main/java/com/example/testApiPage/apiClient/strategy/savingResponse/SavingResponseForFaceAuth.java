package com.example.testApiPage.apiClient.strategy.savingResponse;

import com.example.testApiPage.model.ResponseParam;
import com.example.testApiPage.model.ServiceModel;
import org.springframework.stereotype.Component;

@Component
public class SavingResponseForFaceAuth implements SavingResponse{
    @Override
    public void savingResponse(ResponseParam responseParam, ServiceModel serviceModel) {
        // Service단에 저장할 필드들을 ServiceModel에 저장
    }
}
