package com.example.testApiPage.service;

import com.example.testApiPage.apiClient.driveServer.external.FaceAuthVrifyApiClient;
import com.example.testApiPage.apiClient.strategy.savingResponse.SavingResponseForFaceAuth;
import com.example.testApiPage.apiClient.strategy.settingRequest.SettingRequestForFaceAuth;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CpmFaceAuth extends TestService{

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
            // 요청 파라미터를 세팅하는 전략과 응답 파라미터에서 저장하는 전략을 주입시킨다
            new FaceAuthVrifyApiClient(new SettingRequestForFaceAuth(), new SavingResponseForFaceAuth())
        );
    }
}
