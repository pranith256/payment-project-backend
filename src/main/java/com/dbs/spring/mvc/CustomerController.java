package com.dbs.spring.mvc;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Customer;
import com.dbs.spring.service.BankService;
import com.dbs.spring.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
	public CustomerController()
	{
		
	}
	@Autowired
	private CustomerService service;
//	@GetMapping("/count")
//	public long getCustomerCount()
//	{
//		System.out.println(service.getCustomerCount());
//		return service.getCustomerCount();
//	}
	@GetMapping("/{cid}")
public ResponseEntity<Object> getCustomer(@PathVariable String cid)
	
	{
		try
		{
			
	Customer c=this.service.findCustomerById(cid);
		return ResponseEntity.status(HttpStatus.OK)
				.body(c);
		
		}
		catch(EntityNotFoundException e)
		{
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.OK)
					.body("not found  ");
		}
		
	}


	
}
