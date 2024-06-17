package com.example.testApiPage.service;

import com.example.testApiPage.apiClient.driveServer.external.FaceAuthVrifyApiClient;
import com.example.testApiPage.apiClient.strategy.savingResponse.SavingResponseForFaceAuth;
import com.example.testApiPage.apiClient.strategy.settingRequest.SettingRequestForFaceAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CpmFaceAuth extends TestService{

    // 호출할 ApiClient에 주입할 전략 패턴 객체: 요청 파라미터 세팅
    @Autowired
    SettingRequestForFaceAuth settingRequestForFaceAuth;

    // 호출할 ApiClient에 주입할 전략 패턴 객체: 응답 파라미터 저장
    @Autowired
    SavingResponseForFaceAuth savingResponseForFaceAuth;

    public CpmFaceAuth(){
        super();
    }

    /**
     * setApiClientList
     * <p>
     *     구현한 Service단에서 호출할 apiClient List 세팅 메소드
     * </p>
     */
    @Override
    public void setApiClientList() {
        this.apiClientList = Arrays.asList(
            new FaceAuthVrifyApiClient(settingRequestForFaceAuth, savingResponseForFaceAuth)
        );
    }
}
