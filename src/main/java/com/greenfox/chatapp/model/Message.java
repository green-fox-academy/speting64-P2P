package com.greenfox.chatapp.model;

import org.apache.catalina.User;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String message;
    Timestamp messageCreated;

    long randomId;

    public Message(User username , String message){

        this.id = (int) (1000000+Math.random() * 9999999);
        this.username = username.getUsername();
        this.message = message;
        this.messageCreated = Timestamp.valueOf(LocalDateTime.now());
        this.randomId = randomId;

    }

    public Message () {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageCreated() {
        return messageCreated;
    }

    public void setMessageCreated(Timestamp messageCreated) {
        this.messageCreated = messageCreated;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }
}
