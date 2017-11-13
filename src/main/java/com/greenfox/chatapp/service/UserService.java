package com.greenfox.chatapp.service;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;




@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserService() {

    }

    public List <ChatUser> getAllUser(){
        List<ChatUser> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public ChatUser getNewUser(){
        return new ChatUser();
    }

    public void saveDataBase(ChatUser user){
        userRepo.save(user);
    }
}
