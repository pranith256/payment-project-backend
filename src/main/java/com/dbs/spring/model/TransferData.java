
  
package com.dbs.spring.model;


public class TransferData {
	
	public String sendCustomerId,senderBIC,receiverBIC,receiverAccountNumber,receiverAccHolderName,transferTypeId,messageCodeId,currencyCode;
	public Double transferAmount, transactionFee;
	public Boolean isEmployeeTransfer;
	public Integer employeeId;
	public Integer userid;
	public String messagecode;
	

	public String getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public TransferData() {
	}

	public String getSendCustomerId() {
		return sendCustomerId;
	}

	public void setSendCustomerId(String sendCustomerId) {
		this.sendCustomerId = sendCustomerId;
	}

	public String getSenderBIC() {
		return senderBIC;
	}

	public void setSenderBIC(String senderBIC) {
		this.senderBIC = senderBIC;
	}

	public String getreceiverBIC() {
		return receiverBIC;
	}

	public void setreceiverBIC(String receiverBIC) {
		this.receiverBIC = receiverBIC;
	}

	public String getreceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setreceiverAccountNumber(String receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public String getreceiverAccHolderName() {
		return receiverAccHolderName;
	}

	public void setreceiverAccHolderName(String receiverAccHolderName) {
		this.receiverAccHolderName = receiverAccHolderName;
	}

	public String getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(String transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public String getMessageCodeId() {
		return messageCodeId;
	}

	public void setMessageCodeId(String messageCodeId) {
		this.messageCodeId = messageCodeId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(Double transactionFee) {
		this.transactionFee = transactionFee;
	}

	public Boolean getIsEmployeeTransfer() {
		return isEmployeeTransfer;
	}

	public void setIsEmployeeTransfer(Boolean isEmployeeTransfer) {
		this.isEmployeeTransfer = isEmployeeTransfer;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "TransferTransactionData [sendCustomerId=" + sendCustomerId + ", senderBIC=" + senderBIC
				+ ", receiverBIC=" + receiverBIC + ", receiverAccountNumber=" + receiverAccountNumber
				+ ", receiverAccHolderName=" + receiverAccHolderName + ", transferTypeId=" + transferTypeId
				+ ", messageCodeId=" + messageCodeId + ", currencyCode=" + currencyCode + ", transferAmount="
				+ transferAmount + ", transactionFee=" + transactionFee + ", isEmployeeTransfer=" + isEmployeeTransfer
				+ ", employeeId=" + employeeId + "]";
	}
	
	
	
}
