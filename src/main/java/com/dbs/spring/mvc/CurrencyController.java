package com.dbs.spring.mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Bank;
import com.dbs.spring.model.Currency;
import com.dbs.spring.service.BankService;
import com.dbs.spring.service.CurrencyService;


@CrossOrigin
@RestController
@RequestMapping("/currency")
public class CurrencyController {
	public CurrencyController()
	{
		
	}
	@Autowired
	private CurrencyService service;
	@GetMapping("/curcount")
	public long getCurrCount()
	{
		System.out.println(service.getCurrencyCount());
		return service.getCurrencyCount();
	}
	@GetMapping("/allcurrs")
	public List<Currency> getCurrencys()
	{
		System.out.println(service.getCurrencys());

		return service.getCurrencys();
	}
	@GetMapping("/{id}")
	public Currency getCurrencyById(@PathVariable String id)
	{
		System.out.println(service.findCurrencyById("ABBLINBBXXX"));
		return this.service.findCurrencyById(id);
	}

}
