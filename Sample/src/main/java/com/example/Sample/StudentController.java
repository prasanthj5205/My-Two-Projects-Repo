package com.example.Sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public String greetMsg(){

        return "Hello Spring boot";
    }
}
