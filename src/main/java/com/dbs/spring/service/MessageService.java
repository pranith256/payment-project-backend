package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Message;
import com.dbs.spring.respository.MessageRepository;

@Service
public class MessageService {
	@Autowired
    private MessageRepository repo;
    
    public Message findById(String msgcode) {
        try {
            Optional<Message> message=this.repo.findById(msgcode);
            return message.orElseThrow(()->{
                return new EntityNotFoundException("Message with "+msgcode+" does not exist");
            });
        }
        catch(IllegalArgumentException iae) {
            return null;
        }
    }
    public List<Message> getMessages(){
        List<Message> m=new ArrayList<>();
        this.repo.findAll().forEach(msg->m.add(msg));
        return m;
    }

}
