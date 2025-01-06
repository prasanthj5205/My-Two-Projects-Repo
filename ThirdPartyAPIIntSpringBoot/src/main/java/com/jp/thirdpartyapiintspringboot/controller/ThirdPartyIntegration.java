package com.jp.thirdpartyapiintspringboot.controller;

import com.jp.thirdpartyapiintspringboot.Service.ThirdPartyIntegrationService;
import com.jp.thirdpartyapiintspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThirdPartyIntegration {

    @Autowired
    public ThirdPartyIntegrationService thirdPartyIntegrationService;

    @GetMapping("/getPosts")
    public List<User> getAllPosts(){
        return thirdPartyIntegrationService.getAllPosts();
    }
}
