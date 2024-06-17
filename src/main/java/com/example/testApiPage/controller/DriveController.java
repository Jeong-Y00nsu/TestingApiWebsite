package com.example.testApiPage.controller;

import com.example.testApiPage.service.CpmFaceAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/drive")
public class DriveController {

    private CpmFaceAuth cpmFaceAuth;

    @Autowired
    public DriveController(CpmFaceAuth cpmFaceAuth){
        this.cpmFaceAuth = cpmFaceAuth;
    }

    @RequestMapping("/vrify")
    public String vrify(){
        return cpmFaceAuth.execute();
    }

}
