package com.dbs.spring.respository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Logger;

public interface LoggerRepository extends CrudRepository<Logger,Integer> {

}
