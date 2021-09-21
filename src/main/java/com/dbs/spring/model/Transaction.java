package com.dbs.spring.model;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customerid;
	@ManyToOne
	@JoinColumn(name="senderBIC")
	private Bank senderBIC;
	@ManyToOne
	@JoinColumn(name="receiverBIC")
	private Bank receiverBIC;
	@OneToOne
	@JoinColumn(name="currency")
	private Currency currencycode;
	private String receiveraccountholdernumber;
	@OneToOne
	@JoinColumn(name="transfertypecode")
	private Transfertypes transfertypecode;
	private String receiveraccountholdername;
	@OneToOne
	@JoinColumn(name="messagecode")
	private Message messagecode;
public Double currencyamount;
int transferfees;
int inramount;
public LocalDate transferdate;
public int getTransactionid() {
	return transactionid;
}
public void setTransactionid(int transactionid) {
	this.transactionid = transactionid;
}
public Customer getCustomerid() {
	return customerid;
}
public void setCustomerid(Customer customerid) {
	this.customerid = customerid;
}
public Bank getSenderBIC() {
	return senderBIC;
}
public void setSenderBIC(Bank senderBIC) {
	this.senderBIC = senderBIC;
}
public Bank getreceiverBIC() {
	return receiverBIC;
}
public void setreceiverBIC(Bank receiverBIC) {
	this.receiverBIC = receiverBIC;
}
public Currency getCurrencycode() {
	return currencycode;
}
public void setCurrencycode(Currency currencycode) {
	this.currencycode = currencycode;
}
public String getreceiveraccountholdernumber() {
	return receiveraccountholdernumber;
}
public void setreceiveraccountholdernumber(String receiveraccountholdernumber) {
	this.receiveraccountholdernumber = receiveraccountholdernumber;
}
public Transfertypes getTransfertypecode() {
	return transfertypecode;
}
public void setTransfertypecode(Transfertypes transfertypecode) {
	this.transfertypecode = transfertypecode;
}
public String getReceiveraccountholdername() {
	return receiveraccountholdername;
}
public void setReceiveraccountholdername(String receiveraccountholdername) {
	this.receiveraccountholdername = receiveraccountholdername;
}
public Message getMessagecode() {
	return messagecode;
}
public void setMessagecode(Message messagecode) {
	this.messagecode = messagecode;
}
public Double getCurrencyamount() {
	return currencyamount;
}
public void setCurrencyamount(Double currencyamount) {
	this.currencyamount = currencyamount;
}
public int getTransferfees() {
	return transferfees;
}
public void setTransferfees(int transferfees) {
	this.transferfees = transferfees;
}
public int getInramount() {
	return inramount;
}
public void setInramount(int inramount) {
	this.inramount = inramount;
}
public LocalDate getTransferdate() {
	return transferdate;
}
public void setTransferdate(LocalDate transferdate) {
	this.transferdate = transferdate;
}
public Transaction(int transactionid, Customer customerid, Bank senderBIC, Bank receiverBIC, Currency currencycode,
		String receiveraccountholdernumber, Transfertypes transfertypecode, String receiveraccountholdername,
		Message messagecode, Double currencyamount, int transferfees, int inramount, LocalDate transferdate) {
	super();
	this.transactionid = transactionid;
	this.customerid = customerid;
	this.senderBIC = senderBIC;
	this.receiverBIC = receiverBIC;
	this.currencycode = currencycode;
	this.receiveraccountholdernumber = receiveraccountholdernumber;
	this.transfertypecode = transfertypecode;
	this.receiveraccountholdername = receiveraccountholdername;
	this.messagecode = messagecode;
	this.currencyamount = currencyamount;
	this.transferfees = transferfees;
	this.inramount = inramount;
	this.transferdate = transferdate;
}
public Transaction() {
	
	// TODO Auto-generated constructor stub
}
	



}
