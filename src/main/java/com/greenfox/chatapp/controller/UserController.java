package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class UserController {
/*
    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<ChatUser> getAllChatUsers(){
        return userService.getAllChatUser();
    }

    @RequestMapping("/users/{id}")
    public ChatUser getChatUser (@PathVariable long id){
        return userService.findChatUserById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public void addChatUser (@RequestBody ChatUser user){
        userService.addNewChatUser(user);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void updateChatUser (@RequestBody ChatUser user){
        userService.updateChatUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void deleteChatUser (@PathVariable long id){
        userService.deleteChatUser(id);
    }
*/
}
