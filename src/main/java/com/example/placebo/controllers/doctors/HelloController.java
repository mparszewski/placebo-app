package com.example.placebo.controllers.doctors;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "<h1>hello placebo-app</h1>";
    }
}
