package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.ChatUser;
import com.greenfox.chatapp.model.User;
import org.springframework.data.repository.CrudRepository ;


public interface UserRepo extends CrudRepository<ChatUser , Long> {
}
