package com.jp.thirdpartyapiintspringboot.controller;

import com.jp.thirdpartyapiintspringboot.Service.ThirdPartyIntegrationService;
import com.jp.thirdpartyapiintspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ThirdPartyIntegration {

    @Autowired
    public ThirdPartyIntegrationService thirdPartyIntegrationService;

    @GetMapping("/getPosts")
    public List<User> getAllPosts(){
        return thirdPartyIntegrationService.getAllPosts();
    }

    @GetMapping("/getPostById/{id}")
    public User getPostById(@PathVariable int id){
        return thirdPartyIntegrationService.getPostById(id);
    }

    @PostMapping("/sendPosts")
    public User insertPosts(@RequestBody User user){
        return thirdPartyIntegrationService.insertPosts(user);
    }

    @PutMapping("/updatePost/{id}")
    public User updatePosts(@RequestBody User user, @PathVariable int id){
        return thirdPartyIntegrationService.updatePosts(user,id);
    }

    @DeleteMapping("/deletePost/{id}")
    public Map updatePosts(@PathVariable int id){
        return thirdPartyIntegrationService.deletePosts(id);
    }
}
