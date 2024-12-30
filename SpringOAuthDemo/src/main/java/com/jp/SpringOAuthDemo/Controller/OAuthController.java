package com.jp.SpringOAuthDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/greet")
    public String greetMessage(){
        return "Hello Spring OAuth Client updated";
    }
}
