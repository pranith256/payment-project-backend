package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class UserData {
	
	@Id
	private int  un;
	private String pass;
	public UserData(int un, String pass) {
		super();
		this.un = un;
		this.pass = pass;
	}
	public UserData() {
		super();
	}
	public int getUn() {
		return un;
	}
	public void setUn(int un) {
		this.un = un;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
