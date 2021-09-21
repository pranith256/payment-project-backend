package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transfertypes {
	@Id
	private String transfertypecode;
	private String transfertypedescription;
	public Transfertypes() {
		System.out.println("Transfer types default constructor");
	}

	public Transfertypes(String transfertypecode, String transfertypedescription) {
		super();
		this.transfertypecode = transfertypecode;
		this.transfertypedescription = transfertypedescription;
	}
	public String getTransfertypecode() {
		return transfertypecode;
	}
	public void setTransfertypecode(String transfertypecode) {
		this.transfertypecode = transfertypecode;
	}
	public String getTransfertypedescription() {
		return transfertypedescription;
	}
	public void setTransfertypedescription(String transfertypedescription) {
		this.transfertypedescription = transfertypedescription;
	}
	@Override
	public String toString() {
		return "Transfertypes [transfertypecode=" + transfertypecode + ", transfertypedescription="
				+ transfertypedescription + "]";
	}
	
}
