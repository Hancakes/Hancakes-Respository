package com.hancakes.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Test {

    @GetMapping("test")
    public String test(){
        System.out.println("AAAAAA");
        return "test menthod ok";
    }
}
