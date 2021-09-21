package com.dbs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbs.spring.respository.BankRepository;

@SpringBootApplication
public class PaymentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProjectApplication.class, args);
	}
	
	

}
