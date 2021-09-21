package com.dbs.spring.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Message;
import com.dbs.spring.service.MessageService;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
    private MessageService service;
    @GetMapping("/{msgcode}")
    public ResponseEntity<Object> getMessage(@PathVariable String msgcode) {
        try {
            Message m=this.service.findById(msgcode);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(m);
        }
        catch (EntityNotFoundException e) {
            System.out.println("error");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message not found");
        }
    }
    @GetMapping
    public List<Message> getMessages(){
        return this.service.getMessages();
    }
	
}
