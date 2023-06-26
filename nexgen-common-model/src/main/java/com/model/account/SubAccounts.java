package com.model.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.model.enums.AccountType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SubAccounts {

	@Id
	@Column(name = "SUB_ACCOUNT_NO")
	protected long subAccountNo;

	@Column(name = "BALANCE")
	protected BigDecimal balance;

	@Column(name = "OPENING_DATE")
	protected LocalDateTime openingDate;

	@Column(name = "SUB_ACCOUNT_TYPE")
	protected AccountType subAccountType;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_no", referencedColumnName = "accountNo")
	protected Account acoount;
	
	public abstract String generateSubAccountNo(long subAccountNo);
	
	public abstract String generateMaturityDate(AccountType subAccountType);

}
