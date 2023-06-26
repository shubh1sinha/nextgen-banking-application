package com.model.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CardType {
	
	DEBIT_CARD("Savings Account"),
	CREDIT_CARD("Current Account");
	
	private final String displayName;
	
	private CardType(String displayName) {
		this.displayName = displayName;
	}
	@JsonCreator
	public static CardType fromStringValue(String value) {
		return Arrays.stream(values()).filter(e->e.displayName.equalsIgnoreCase(value)).findFirst().orElse(null);
				
	}
	
	@Override
	@JsonValue
	public String toString() {
		return displayName;
	}

}
