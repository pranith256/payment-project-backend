package com.dbs.spring.mvc;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Bank;
import com.dbs.spring.service.BankService;

@CrossOrigin
@RestController
@RequestMapping("/bank")
public class BankController {
	public BankController()
	{
		
	}
	@Autowired
	private BankService service;
	@GetMapping("/count")
	public long getBankCount()
	{
		System.out.println(service.getBankCount());
		return service.getBankCount();
	}
	@GetMapping("/allbanks")
	public List<Bank> getBanks()
	{
		System.out.println(service.getBanks());

		return service.getBanks();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getBankById(@PathVariable String id)
	{
		try {
            Bank b=this.service.findBankById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(b);
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(e.getMessage());
        }
	}

}
