package com.greenfox.chatapp.service;

import com.greenfox.chatapp.model.Client;
import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.ResponseMessage;
import com.greenfox.chatapp.model.TransferMessage;
import com.greenfox.chatapp.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    @Autowired
    MessageRepo messageRepo;

    public MessageService() {
    }

    public MessageRepo getMessageRepo() {
        return messageRepo;
    }

    public void setMessageRepo(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public void saveDataBase(Message message){
        messageRepo.save(message);
    }

    public ResponseMessage sendMessage(Message message){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pkrisz0chatapp.herokuapp.com/api/message/receive";
        TransferMessage sendIt = new TransferMessage(message, new Client());
        HttpEntity<TransferMessage> request = new HttpEntity<>(sendIt);
        ResponseMessage response = restTemplate.postForObject(url,request,ResponseMessage.class);
        return response;

    }
}
