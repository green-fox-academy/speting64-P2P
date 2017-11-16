package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class TransferMessage {

    Message message;
    Client client;

    public TransferMessage(){

    }

    public TransferMessage(Message message , Client client){

        this.message=message;
        this.client=client;


    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
