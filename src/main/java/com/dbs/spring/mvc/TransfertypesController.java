package com.dbs.spring.mvc;

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
import com.dbs.spring.model.Transfertypes;
import com.dbs.spring.service.TransfertypeService;

@CrossOrigin
@RestController
@RequestMapping("/transfertypes")
public class TransfertypesController {

	@Autowired
    private TransfertypeService service;
    @GetMapping
    public List<Transfertypes> getAllTransferTypes(){
        return this.service.getAllTransferTypes();
    }
    @GetMapping("/{tid}")
    public ResponseEntity<Object> getTransfertype(@PathVariable String tid) {
        try {
            Transfertypes m=this.service.findById(tid);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(m);
        }
        catch (EntityNotFoundException e) {
            System.out.println("error");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message not found");
        }
    }
}
