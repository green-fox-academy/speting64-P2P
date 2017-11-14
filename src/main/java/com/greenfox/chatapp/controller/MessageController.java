package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.repository.LogRepo;
import com.greenfox.chatapp.repository.MessageRepo;
import com.greenfox.chatapp.repository.UserRepo;
import com.greenfox.chatapp.service.LogService;
import com.greenfox.chatapp.service.MessageService;
import com.greenfox.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;


import javax.servlet.http.HttpServletRequest;

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


    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest request) {
        logService.enviromentCheck(request);
        if(size(userRepo.findAll())==0){
            return "enter";
        }else{
            logService.enviromentCheck(request);
            model.addAttribute("user" ,userService.getChatUser());// userService.findChatUserById(1L));
            model.addAttribute("message" , messageRepo.findAll());
            return "main";
        }
    }

    @PostMapping("/add")
    public String updateEntry(@ModelAttribute ChatUser user, Model model , HttpServletRequest request){
        logService.enviromentCheck(request);
        //model.addAttribute("newUser", user);
        if (user.getName().equals("")) {
            model.addAttribute("errorMessage", "Add username plzzzz");
            return "enter";
        } else if (user.getName().equals("foulmouth")) {
            model.addAttribute("errorMessage2","Bad bad user");
            return "enter";
        }
        userService.saveDataBase(user);
        return "redirect:/";
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
    public String messageIndex(HttpServletRequest request, @ModelAttribute Message message,
                               @RequestParam(value = "text") String text){
        logService.enviromentCheck(request);
        messageRepo.save(new Message(userService.getChatUser().getName(),text));
        return "redirect:/";
    }


}
