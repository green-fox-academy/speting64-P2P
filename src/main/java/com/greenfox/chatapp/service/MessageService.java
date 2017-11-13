package com.greenfox.chatapp.service;

import com.greenfox.chatapp.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;

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
}
