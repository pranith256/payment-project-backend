package com.dbs.spring.respository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Currency;

public interface CurrencyRepository  extends CrudRepository<Currency , String>{

}
