package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Customer;
import com.dbs.spring.respository.CustomerRepository;

@Service
public class CustomerService {

	public CustomerService()
	{}
	@Autowired
	private CustomerRepository customer;
	public long getCustomerCount()
	{
		return this.customer.count();
	}
	public List<Customer> getCustomers()
	{
		List<Customer> cust = new ArrayList<Customer>();
		this.customer.findAll().forEach(curr->cust.add(curr));
		return cust;
		
	}
	public Customer findCustomerById(String id)
	{
		try { 
			Optional<Customer> c=this.customer.findById(id);
			return c.orElseThrow(()-> {
					return new EntityNotFoundException("product with" +id+"does not exist");
			});
			
		}
		
		catch(IllegalArgumentException iae)
		{
			return null;
			
		}
		
		
		
	}
	public boolean updateCustomer(Customer cust) {
		
		try {
			if(this.customer.findById(cust.getCustomerid()).isPresent())
				return this.customer.save(cust)!=null;
			return false;
		}catch(Exception e) {
			return false;
		}
		// TODO Auto-generated method stub
		
	}
}
