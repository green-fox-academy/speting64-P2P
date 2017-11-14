package com.greenfox.chatapp.service;

import com.greenfox.chatapp.model.ResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public ResponseMessage statusOK(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus("OK");
        return responseMessage;
    }

    public ResponseMessage statusError(String errorMessage){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus("error");
        responseMessage.setMessage(errorMessage);
        return responseMessage;

    }
}
