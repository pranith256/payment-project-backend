package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Currency;
import com.dbs.spring.respository.CurrencyRepository;

@Service
public class CurrencyService {
	public CurrencyService()
	{}
	@Autowired
	private CurrencyRepository currrepo;
	public long getCurrencyCount()
	{
		return this.currrepo.count();
	}
	public List<Currency> getCurrencys()
	{
		List<Currency> currs = new ArrayList<Currency>();
		this.currrepo.findAll().forEach(curr->currs.add(curr));
		return currs;
		
	}
	public Currency findCurrencyById(String id)
	{
		Optional<Currency> curr = this.currrepo.findById(id);
		return curr.orElseThrow(null);
		
		
		
	}

}
