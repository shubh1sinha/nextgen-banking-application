package com.model.account;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.model.user.SweepRequested;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity
@Table(name = "SALARIED_ACCOUNT")
public class SalariedAccount extends Account {
	
	@Column(name = "INTRESTEARNED")
	protected BigDecimal intrestEarned;
	
	public SalariedAccount() {
		super();
	}

	@Override
	public BigDecimal getInrestRate(SweepRequested sweepReq) {

		// TODO Auto-generated method stub
		final double interestRate = 0.04;
		final double sweepIntrestRate = 0.08;
		BigDecimal sweepBalance = balance.multiply(BigDecimal.valueOf(sweepReq.getPercentage()).divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
		if (sweepReq.getIsSweepOpted().equalsIgnoreCase("true")) {
			
			intrestEarned = sweepBalance.multiply(BigDecimal.valueOf(sweepIntrestRate * 30)).divide(BigDecimal.valueOf(365.0),
					RoundingMode.HALF_UP).add(balance.multiply(BigDecimal.valueOf(interestRate * 30)).divide(BigDecimal.valueOf(365.0),
					RoundingMode.HALF_UP));
		} else {
			intrestEarned = balance.multiply(BigDecimal.valueOf(interestRate * 30)).divide(BigDecimal.valueOf(365.0),
					RoundingMode.HALF_UP);
		}
		return intrestEarned;
	
	}

}
