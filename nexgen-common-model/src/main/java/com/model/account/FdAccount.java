package com.model.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.model.enums.AccountType;

import jakarta.persistence.Column;

public class FdAccount extends SubAccounts{
	
	@Column(name="ACCOUNT_NO")
	protected long fdAccountNo;
	
	@Column(name = "MATURITYDATE")
	protected LocalDateTime maturityDate;
	
	@Column(name = "INTRESTEARED")
	protected BigDecimal intrestEarned;
	
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
