package com.greenfox.chatapp.service;

import com.greenfox.chatapp.model.LogMessage;
import com.greenfox.chatapp.repository.LogRepo;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LogService {
/*
    public void enviromentCheck(HttpServletRequest request){
        if(System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")){
            System.out.println(new LogMessage(request).toString());
        }else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")){

                System.err.println(new LogMessage(request).toString());
            }
    }
    */

    @Autowired
    LogRepo logRepo;

    public LogService(){

    }

    public LogRepo getLogRepo() {
        return logRepo;
    }

    public void setLogRepo(LogRepo logRepo) {
        this.logRepo = logRepo;
    }
}
