package com.dbs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Customeruser;
import com.dbs.spring.respository.CustomeruserRespository;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomeruserService {
	
	@Autowired
	private CustomeruserRespository repo;
	public Customeruser getAllBycustomerId(Integer string){
		 try {
	            Optional<Customeruser> c=this.repo.findById(string);
	            return c.orElseThrow(()->{
	                return new EntityNotFoundException("Invalid Credentials");
	            });
	            }
	        catch(IllegalArgumentException e) {
	        	System.out.println("Error: "+e.getMessage());
				return null;
	        }
	        }

}
