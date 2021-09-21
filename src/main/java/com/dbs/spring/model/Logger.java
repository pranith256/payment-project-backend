package com.dbs.spring.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Logger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loggerid;
	@OneToOne
	@JoinColumn(name="userid")
	private Customeruser userid;
	@OneToOne
	@JoinColumn(name="employeeidid")
	private Employee employeeid;
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customerid;
	private String screenname;
	private String action;
	private String ipaddress;
	public Logger() {
		System.out.println("Logger default constructor");
	}
	public int getLoggerid() {
		return loggerid;
	}
	public void setLoggerid(int loggerid) {
		this.loggerid = loggerid;
	}
	public Customeruser getUserid() {
		return userid;
	}
	public void setUserid(Customeruser userid) {
		this.userid = userid;
	}
	public Employee getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Employee employeeid) {
		this.employeeid = employeeid;
	}
	public Customer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Customer customerid) {
		this.customerid = customerid;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public Logger(int loggerid, Customeruser userid, Employee employeeid, Customer customerid, String screenname,
			String action, String ipaddress) {
		super();
		this.loggerid = loggerid;
		this.userid = userid;
		this.employeeid = employeeid;
		this.customerid = customerid;
		this.screenname = screenname;
		this.action = action;
		this.ipaddress = ipaddress;
	}
	

}
