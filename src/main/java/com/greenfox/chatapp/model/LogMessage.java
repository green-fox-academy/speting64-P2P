package com.greenfox.chatapp.model;

import javax.servlet.http.HttpServletRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class LogMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String path;
    String method;
    String dateAndTime;
    String logLevel;
    String param;

    public LogMessage() {

    }

    public LogMessage (HttpServletRequest request){

        this.method = request.getMethod();
        this.path = request.getRequestURI();
        this.dateAndTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.logLevel= System.getenv("CHAT_APP_LOGLEVEL");
        this.param = request.getQueryString();
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", param='" + param + '\'' +
                '}';
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

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
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
