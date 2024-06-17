package com.example.testApiPage.service;

import com.example.testApiPage.apiClient.ApiClient;
import com.example.testApiPage.apiClient.strategy.savingResponse.SavingResponse;
import com.example.testApiPage.apiClient.strategy.settingRequest.SettingRequest;
import com.example.testApiPage.model.ResponseParam;
import com.example.testApiPage.model.ServiceModel;
import com.example.testApiPage.util.JPrint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class TestService {
    protected List<ApiClient> apiClientList;

    private ServiceModel serviceModel;

    /**
     * setApiClientListElement
     * @param index apiClientList에서 호출 순서
     * @param settingRequest 새롭게 바꿀 요청 파라미터 세팅 전략
     * @param savingResponse 새롭게 바꿀 응답 파라미터 저장 전략
     */
    public void setApiClientListElement(int index, SettingRequest settingRequest, SavingResponse savingResponse){
        if(settingRequest != null) this.apiClientList.get(index).settingRequest = settingRequest;
        if(savingResponse != null) this.apiClientList.get(index).savingResponse = savingResponse;
    }
    public void setServiceModel(ServiceModel serviceModel){
        this.serviceModel = serviceModel;
    }

    public ServiceModel getServiceModel(){
        return this.serviceModel;
    }

    /**
     * execute
     * <p>
     *     Service객체를 생성한 쪽에서 주입한 apiList를 순차적으로 호출하는 로직
     *     api를 순차적으로 호출하다가 중간에 성공응답이 아닌 경우 종료
     * </p>
     * @return 가장 마지막에 호출된 api의 응답 json을 String으로 바꾼값
     */
    public String execute(){
        // 모든 apiClient의 요청파라미터, 응답파라미터를 세팅하는 방법을 전략 패턴 클래스를 세팅
        this.setApiClientList();
        ResponseParam responseParam = new ResponseParam();
        
        // 서비스를 이루는 api를 순차적으로 호출한다.
        for(ApiClient apiClient:apiClientList){
            // API 호출 전 요청 파라미터 세팅
            apiClient.settingRequest.settingRequest(this.serviceModel, apiClient.requestParam);
            // api 호출
            responseParam = apiClient.callApi();
            // api 호출 후 성공 응답이 아니면 종료
            if(!responseParam.isSuccess()) break;
            // 다음 API를 위해 필요한 부분을 ServiceModel에 저장
            apiClient.savingResponse.savingResponse(responseParam, this.serviceModel);
        }
        return JPrint.toString(responseParam);
    }

    // 입력받은
    public abstract void setApiClientList();
}
