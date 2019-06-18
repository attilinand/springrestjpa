package com.boot.mytrainings.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.mytrainings.service.PlayerService;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	PlayerService playerService;

    @GetMapping
    public String sayHello() {
        return "welcome to our first rest endpoint";
    }
}
