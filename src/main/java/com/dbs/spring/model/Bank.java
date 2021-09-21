package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.dbs.spring.constants.Constants;

@Entity
public class Bank {
	
	@Id
	private String bic;
	private String bankname;
		public Bank() {
		System.out.println("Bank default constructor");
	}

	public Bank(String bic, String bankname) {
		super();
		System.out.println("Bank parameterised constructor ");
		this.bic = bic;
		this.bankname = bankname;
	}

	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", bankname=" + bankname + "]";
	}
public boolean isInternalBank() {
		
		return this.bankname.contains(Constants.OWN_BANK);
	}
	
}
