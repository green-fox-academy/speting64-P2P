package com.greenfox.chatapp.model;

import org.apache.catalina.User;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    int id;
    String userName;
    String text;
    String messageCreated;

    public Message () {

        this.id = randProvider();
        this.messageCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

    }

    public Message(String userName , String text){

        this.id = randProvider();
        this.userName = userName;
        this.text = text;
        this.messageCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

    }

    public int randProvider(){
        Random rand = new Random();
        int randId = rand.nextInt(9999999) + 1000000;
        return randId;
    }


    public int getId() {
        return id;
    }

    public void setId() {
        this.id = randProvider();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMessageCreated() {
        return messageCreated;
    }

    public void setMessageCreated(String messageCreated) {
        this.messageCreated = messageCreated;
    }

}
