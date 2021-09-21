package com.dbs.spring.respository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Employee;

public interface EmployeeRepository  extends CrudRepository<Employee , Integer >{

}
