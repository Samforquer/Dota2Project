package com.example.dota2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/herostats")
public class HeroController {
    @GetMapping("/herostats")
    public String test(){
        return "heroes list";
    }
}
