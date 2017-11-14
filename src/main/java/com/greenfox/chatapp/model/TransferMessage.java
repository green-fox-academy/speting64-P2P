package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class TransferMessage {

    Message message;
    Client client;

    public TransferMessage(){

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

    @Override
    public String toString() {
        return "TransferMessage{" +
                "message=" + message +
                ", client=" + client +
                '}';
    }
}
