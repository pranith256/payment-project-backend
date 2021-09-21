package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Bank;
import com.dbs.spring.respository.BankRepository;

@Service
public class BankService {
	
	public BankService()
	{
		
	}
	@Autowired
	private BankRepository bankrepo;
	public long getBankCount()
	{
		return this.bankrepo.count();
	}
	public List<Bank> getBanks()
	{
		List<Bank> bank = new ArrayList<Bank>();
		this.bankrepo.findAll().forEach(bank1->bank.add(bank1));
		return bank;
		
	}
	public Bank findBankById(String id)
	{
		try {
            Optional<Bank> c=this.bankrepo.findById(id);
            return c.orElseThrow(()->{
                return new EntityNotFoundException("Bank with "+id + " does not exist");
            });
            }
        catch(IllegalArgumentException iae) {
            return null;
        }
		
		
	}

}
