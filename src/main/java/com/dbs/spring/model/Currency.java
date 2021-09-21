package com.dbs.spring.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {

	@Id
	private String currencycode;
	private String currencyname;
	private long conversionrate;
	public Currency() {
		System.out.println("Currency default constructor");
	}

	public Currency(String currencycode, String currencyname, long conversionrate) {
		super();
		System.out.println("Currency parameterised constructor ");
		this.currencycode = currencycode;
		this.currencyname = currencyname;
		this.conversionrate = conversionrate;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public long getConversionrate() {
		return conversionrate;
	}
	public void setConversionrate(long conversionrate) {
		this.conversionrate = conversionrate;
	}
	@Override
	public String toString() {
		return "Currency [currencycode=" + currencycode + ", currencyname=" + currencyname + ", conversionrate="
				+ conversionrate + "]";
	}
	
}
