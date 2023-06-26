package com.model.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CardCategories {

	VISA_CARD("Visa"), 
	MASTERCARD("MasterCard"), 
	RUBYX_CARD("Rubyx"), 
	PLATINUM_CARD("Platinum");

	private final String displayName;

	private CardCategories(String displayName) {
		this.displayName = displayName;
	}

	@JsonCreator
	public static CardCategories fromStringValue(String value) {
		return Arrays.stream(values()).filter(e -> e.displayName.equalsIgnoreCase(value)).findFirst().orElse(null);

	}

	@Override
	@JsonValue
	public String toString() {
		return displayName;
	}
}
