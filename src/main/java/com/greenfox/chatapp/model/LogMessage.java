package com.greenfox.chatapp.model;

import javax.servlet.http.HttpServletRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class LogMessage {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String path;
    String method;
    String createdAt;
    String logLevel;
    String param;

    public LogMessage() {

    }

    public LogMessage(String path, String method, String createdAt , String logLevel , String param){
        this.path = path;
        this.method = method;
        this.createdAt = createdAt;
        this.logLevel = logLevel;
        this.param = param;
    }

    public LogMessage (HttpServletRequest request){

        this.method = request.getMethod();
        this.path = request.getRequestURI();
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        this.logLevel= System.getenv("CHAT_APP_LOGLEVEL");
        this.param = request.getQueryString();
    }

    @Override
    public String toString() {
        return createdAt + " " + logLevel + " " + path + " " + method + " " + param;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
