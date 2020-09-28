package com.rituj.elasticsearch.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SearchController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public String search(@RequestHeader final String test) {
        
        System.out.println("header is as: "+ test);
        return "Hello World" + test;
    }
}
