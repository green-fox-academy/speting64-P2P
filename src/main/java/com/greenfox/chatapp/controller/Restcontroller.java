package com.greenfox.chatapp.controller;
import com.greenfox.chatapp.model.LogMessage;
import com.greenfox.chatapp.model.ResponseMessage;
import com.greenfox.chatapp.model.TransferMessage;
import com.greenfox.chatapp.repository.LogRepo;
import com.greenfox.chatapp.repository.MessageRepo;
import com.greenfox.chatapp.service.LogService;
import com.greenfox.chatapp.service.MessageService;
import com.greenfox.chatapp.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

    @Autowired
    MessageRepo messageRepo;

    @CrossOrigin("*")
    @PostMapping(value = "/api/message/receive")
    public Object recieveStatus(HttpServletRequest request , @RequestBody TransferMessage transfer){
        logService.enviromentCheck(request);
        if(responseService.checkFields(transfer).equals("")){
            messageRepo.save(transfer.getMessage());
            return "{\"status\": \"ok\"}";
        }
        else{
            return new ResponseEntity(new ResponseMessage("error" , "Missing fields: " + responseService.checkFields(transfer)), HttpStatus.BAD_REQUEST);
        }

    }
}

