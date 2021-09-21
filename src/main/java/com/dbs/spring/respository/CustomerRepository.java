package com.dbs.spring.respository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer , String> {

}
