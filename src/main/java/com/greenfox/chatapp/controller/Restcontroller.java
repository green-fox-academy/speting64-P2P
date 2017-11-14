package com.greenfox.chatapp.controller;
import com.greenfox.chatapp.model.LogMessage;
import com.greenfox.chatapp.model.ResponseMessage;
import com.greenfox.chatapp.model.TransferMessage;
import com.greenfox.chatapp.repository.LogRepo;
import com.greenfox.chatapp.service.LogService;
import com.greenfox.chatapp.service.MessageService;
import com.greenfox.chatapp.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Restcontroller {

    @Autowired
    LogService logService;

    @Autowired
    LogRepo logRepo;

    @Autowired
    ResponseService responseService;

    @Autowired
    MessageService messageService;
/*
    @RequestMapping(value = "/api/message/receive", method = RequestMethod.POST)
    public ResponseMessage recieveMessage(@RequestBody TransferMessage transferMessage){
        String errorString = messageService.c
    }
*/
}
