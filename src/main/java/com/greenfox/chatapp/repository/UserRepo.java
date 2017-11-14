package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.ChatUser;
import org.springframework.data.repository.CrudRepository ;
import org.springframework.data.jpa.repository.Query;


public interface UserRepo extends CrudRepository<ChatUser , Long> {
}
