package com.dbs.spring.respository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Bank;

public interface BankRepository extends CrudRepository< Bank , String> {

	
}
