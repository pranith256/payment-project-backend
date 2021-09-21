package com.dbs.spring.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customeruser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String userpassword;
	private String customerid;
	public Customeruser() {
		System.out.println("Customer user  default constructor");
	}

	public Customeruser(int userid, String username, String userpassword, String customerid) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.customerid = customerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "Customeruser [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword
				+ ", customerid=" + customerid + "]";
	}
	
}
