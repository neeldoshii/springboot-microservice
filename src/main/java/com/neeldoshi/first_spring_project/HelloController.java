package com.neeldoshi.first_spring_project;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hello World"+name;
    }
}
