package com.greenfox.chatapp.repository;

import com.greenfox.chatapp.model.LogMessage;
import org.springframework.data.repository.CrudRepository ;

public interface LogRepo extends CrudRepository <LogMessage , Long> {
}
