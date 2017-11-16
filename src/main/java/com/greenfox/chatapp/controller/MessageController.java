package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.model.Client;
import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.TransferMessage;
import com.greenfox.chatapp.repository.LogRepo;
import com.greenfox.chatapp.repository.MessageRepo;
import com.greenfox.chatapp.repository.UserRepo;
import com.greenfox.chatapp.service.LogService;
import com.greenfox.chatapp.service.MessageService;
import com.greenfox.chatapp.service.ResponseService;
import com.greenfox.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;


import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
public class MessageController {

    @Autowired
    LogService logService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    ResponseService responseService;


    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest request) {
        logService.enviromentCheck(request);
        if(size(userRepo.findAll())==0){
            return "enter";
        }else{
            logService.enviromentCheck(request);
            model.addAttribute("user" ,userService.getChatUser());
            model.addAttribute("messages" , messageRepo.findAll());
            return "main";
        }
    }

    @GetMapping("/enter")
    public String getEnterPage(Model model ,  HttpServletRequest request){
        logService.enviromentCheck(request);
        return "enter";
    }

    @PostMapping("/save")
    public String saveChatUser (@RequestParam String name ,  HttpServletRequest request){
        logService.enviromentCheck(request);
        userRepo.save(new ChatUser(name));
        return "redirect:/";
    }

    @PostMapping(value = "/updateuser")
    public String updatePost(HttpServletRequest request, @ModelAttribute ChatUser user) {
        logService.enviromentCheck(request);
        userRepo.save(user);
        return "redirect:/";
    }

    @PostMapping("/savemessage")
    public String messageIndex(Model model , HttpServletRequest request, @ModelAttribute Message message,
                               @RequestParam(value = "text") String text){
        logService.enviromentCheck(request);
        model.addAttribute("message", new Message());
        message.setUserName(userRepo.findOne(1L).getName());
        message.setId(message.randProvider());
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        responseService.sendMessage(new TransferMessage(message,new Client(System.getenv("CHAT_APP_UNIQUE_ID"))));
        messageRepo.save(new Message(userService.getChatUser().getName(),text));
        return "redirect:/";
    }

    /*@PostMapping("/messages/send")
    public String sendMessage(@ModelAttribute Message message){
        message.setUserName(userService.getChatUser().getName());
        messageService.saveDataBase(message);
        messageService.sendMessage(message);
        return "redirect:/";
    }*/


}
