package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.repository.LogRepo;
import com.greenfox.chatapp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageController {

    @Autowired
    LogRepo logRepo;

    @Autowired
    LogService logService;
/*
    @RequestMapping("/")
    public String mainPage(){
        return "Peer to Peer App";
    }*/

    @GetMapping(value = "/main")
    public String index(HttpServletRequest request , Exception e){
        logService.enviromentCheck(request,e);
        return "main";
    }

}
