package com.dbs.spring.respository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Message;

public interface MessageRepository extends CrudRepository<Message,String> {

}
