package com.greenfox.chatapp.service;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.ResponseMessage;

import com.greenfox.chatapp.model.TransferMessage;
import com.greenfox.chatapp.repository.MessageRepo;
import com.greenfox.chatapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class ResponseService {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    UserRepo userRepo;

    public ChatUser getFirstUser() {
        return userRepo.findOne(1l);
    }

    public String checkFields(TransferMessage transfer){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (transfer.getMessage().getUserName() == null || transfer.getMessage().getUserName().isEmpty()){
            sb.append("message.userName");
        } if (transfer.getMessage().getText() == null || transfer.getMessage().getText().isEmpty()) {
            sb.append(", ");
            sb.append("message.text");
        } if (transfer.getMessage().getTimestamp() == null){
            sb.append(", ");
            sb.append("message.timestamp");
        } if (transfer.getMessage().getId() == null ){
            sb.append(", ");
            sb.append("message.messageId");
        }  if (transfer.getClient() == null || transfer.getClient().getId() == null  ||
                transfer.getClient().getId().isEmpty()) {
            sb.append(", ");
            sb.append("client.id");
        }
        return sb.toString();
    }

    public void sendMessage(TransferMessage transfer){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<TransferMessage> request = new HttpEntity<>(transfer);
        ResponseMessage s = restTemplate.postForObject(System.getenv("CHAT_APP_PEER_ADDRESS"),request,ResponseMessage.class);

    }



}
