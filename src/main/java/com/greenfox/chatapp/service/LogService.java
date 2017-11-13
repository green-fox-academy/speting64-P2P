package com.greenfox.chatapp.service;

import com.greenfox.chatapp.model.LogMessage;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LogService {

    public void enviromentCheck(HttpServletRequest request , Exception e){
        if(System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")){
            System.out.println(new LogMessage(request).toString());
        }else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")){
            if(e != null){
                System.err.println(new LogMessage(request).toString());
            }
        }
    }
}
