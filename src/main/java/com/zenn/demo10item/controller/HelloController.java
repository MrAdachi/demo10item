package com.zenn.demo10item.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenn.demo10item.dto.Sample;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
    @GetMapping
    public Sample hello(){
        Sample sample = new Sample();
        sample.setId(100);
        sample.setName("taro");

        return  sample;
    }
}
