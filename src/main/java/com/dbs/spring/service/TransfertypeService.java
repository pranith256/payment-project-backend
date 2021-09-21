package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Message;
import com.dbs.spring.model.Transfertypes;
import com.dbs.spring.respository.TransfertypesRepository;

@Service
public class TransfertypeService {
	
	@Autowired
    private TransfertypesRepository repo;
	
	public Transfertypes findById(String tid) {
        try {
            Optional<Transfertypes> message=this.repo.findById(tid);
            return message.orElseThrow(()->{
                return new EntityNotFoundException("Message with "+tid+" does not exist");
            });
        }
        catch(IllegalArgumentException iae) {
            return null;
        }
    }
    
    public List<Transfertypes> getAllTransferTypes(){
        List<Transfertypes> t=new ArrayList<Transfertypes>();
        this.repo.findAll().forEach(tt->t.add(tt));
        return t;
    }

}
