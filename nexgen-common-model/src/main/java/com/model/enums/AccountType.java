package com.model.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountType {
	
	SAVINGS_ACCOUNT("Savings Account"),
	SALARIED_ACCOUNT("Salaried Account"),
	FD("Fixed Deposit"),
	RD("Recurring Deposit"),
	UPI("UPI"),
	MF("Mutual Fund");
	
	
	private final String displayName;
	
	private AccountType(String displayName) {
		this.displayName = displayName;
	}
	@JsonCreator
	public static AccountType fromStringValue(String value) {
		return Arrays.stream(values()).filter(e->e.displayName.equalsIgnoreCase(value)).findFirst().orElse(null);
				
	}
	
	@Override
	@JsonValue
	public String toString() {
		return displayName;
	}
}
