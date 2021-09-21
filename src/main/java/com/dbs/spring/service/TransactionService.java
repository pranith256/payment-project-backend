package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Transaction;
import com.dbs.spring.respository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository repository;

	public int insertTransaction(Transaction trasaction) {
		if (this.repository.findById(trasaction.getTransactionid()).isPresent())
			return -1;
		try {
			Integer id =  this.repository.save(trasaction).getTransactionid();
			return id;
		} catch (Exception e) {
			System.out.println(e);
			return -2;
		}
	}
		public List<Transaction> getAllById(String cid) {
			List<Transaction>  transactions = new ArrayList<Transaction>();
			this.repository.findAllByCustomeridCustomerid(cid).forEach(tt->transactions.add(tt));
			return transactions;
	}

}
