package com.model.account;

import com.model.enums.AccountType;

import jakarta.persistence.Column;

public class UpiAccount extends SubAccounts{
	
	@Column(name="UPI")
	private String upiId;
	
	@Column(name="UPI_NUMBER")
	private long upiNumber;

	@Override
	public String generateSubAccountNo(long subAccountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateMaturityDate(AccountType subAccountType) {
		// TODO Auto-generated method stub
		return null;
	}

}
