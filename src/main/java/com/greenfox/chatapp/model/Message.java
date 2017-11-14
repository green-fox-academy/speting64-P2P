package com.greenfox.chatapp.model;

import org.apache.catalina.User;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String userName;
    String text;
    String messageCreated;

    long randomId;

    public Message(String userName , String text){

        this.id = randomId();
        this.userName = userName;
        this.text = text;
        this.messageCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

    }

    public Message () {

        this.id = randomId();
        this.messageCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

    }

    public Long randomId() {
        long id = ThreadLocalRandom.current().nextLong(1000000,9999999);
        return id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }
}
