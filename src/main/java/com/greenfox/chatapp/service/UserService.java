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

    public List <ChatUser> getAllChatUser(){
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

    public ChatUser getChatUser() {
        return userRepo.findOne(1L);
    }

    public ChatUser findChatUserById(long id){
        return userRepo.findOne(id);
    }

    public Iterable<ChatUser> findAllChatUsers(){
        return userRepo.findAll();
    }

    public ChatUser getNewChatUser(){
        return new ChatUser();
    }

    public void addNewChatUser(ChatUser user){
        userRepo.save(user);
    }


    public void updateChatUser(ChatUser user){
        userRepo.save(user);
    }

    public void deleteChatUser(long id){
        userRepo.delete(id);
    }

    public void saveDataBase(ChatUser user){
        userRepo.save(user);
    }
}
