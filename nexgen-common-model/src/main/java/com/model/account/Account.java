package com.model.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.model.user.SweepRequested;
import com.model.user.User;

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
public abstract class Account {

	@Id
	@Column(name = "ACCOUNT_NO")
	protected long accountNo;

	@Column(name = "BALANCE")
	protected BigDecimal balance;

	@Column(name = "OPENING_DATE")
	protected LocalDateTime openingDate;

	@Column(name = "ACCOUNT_TYPE")
	protected AccountType accountType;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	protected User user;
	
	public abstract BigDecimal getInrestRate(SweepRequested sweepReq);

}
