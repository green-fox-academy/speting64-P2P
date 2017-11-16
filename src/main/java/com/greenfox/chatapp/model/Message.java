package com.greenfox.chatapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "id")
    Long id;
    @JsonProperty(value = "username")
    String userName;
    @JsonProperty(value = "text")
    String text;
    @JsonProperty(value = "timestamp")
    Timestamp timestamp;

    public Message() {

        this.id = randProvider();
        this.timestamp = new Timestamp(System.currentTimeMillis());

    }

    public Message(String userName, String text) {

        this.id = randProvider();
        this.userName = userName;
        this.text = text;
        this.timestamp = new Timestamp(System.currentTimeMillis());

    }

    public Message(Long id, String userName, String text, Timestamp timestamp) {
        this.id = id;
        this.userName = userName;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Long randProvider() {
        Random rand = new Random();
        long randId = rand.nextInt(9999999) + 1000000;
        return randId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
