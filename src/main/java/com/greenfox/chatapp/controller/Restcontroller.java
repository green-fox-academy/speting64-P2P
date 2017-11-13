package com.greenfox.chatapp.controller;
import com.greenfox.chatapp.model.LogMessage;
import com.greenfox.chatapp.repository.LogRepo;
import com.greenfox.chatapp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;


@RestController
public class Restcontroller {

    @Autowired
    LogService logService;

    @Autowired
    LogRepo logRepo;

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public void log (HttpServletRequest request , Exception e){
        logService.enviromentCheck(request,e);
         }
}
