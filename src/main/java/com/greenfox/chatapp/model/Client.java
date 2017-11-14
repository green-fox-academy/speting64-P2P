package com.greenfox.chatapp.model;


import org.springframework.stereotype.Component;

@Component
public class Client {

    String id;

    public Client(){

    }

    public Client(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                '}';
    }
}
