package com.dbs.spring.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction , Integer> {

	public List<Transaction> findAllByCustomeridCustomerid(String cid);

}
