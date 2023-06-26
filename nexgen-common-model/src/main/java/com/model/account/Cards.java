package com.model.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;

import com.model.enums.CardType;

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
public abstract class Cards {
	@Id
	@Column(name = "CARD_NO")
	protected long cardNo;

	@Column(name = "ISSUE_DATE")
	protected LocalDateTime issueDate;

	@Column(name = "VALID_UPTO")
	protected LocalDateTime validUpto;

	@Column(name = "CARD_TYPE")
	protected CardType cardType;
	
	@Column(name = "CARD_LIMIT")
	protected BigDecimal cardLimit;
	
	@Column(name="IS_ACTIVE")
	@Value("true")
	protected String isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_no", referencedColumnName = "accountNo")
	protected Account account;

	public abstract String generateCardCategory(long cardNo);

}
