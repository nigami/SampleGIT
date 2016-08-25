package com.project.trading.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Investors")
@PrimaryKeyJoinColumn(name="userId")

public class Investor extends User{
	
	@Column(name="panCardNum")
	private String panCardNum;
	
	@Column(name="accountNum")
	private String accountNum;
	
	@Column(name="amount")
	private String amount;
	
	public Investor()
	{
		
	}


	public String getPanCardNum() {
		return panCardNum;
	}

	public void setPanCardNum(String panCardNum) {
		this.panCardNum = panCardNum;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	

}
