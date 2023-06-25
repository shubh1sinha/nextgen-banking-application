package com.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {
	
	@Id
	@Column(name="ADDRESSID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column(name="houseNo")
	private String houseNo;
	
	@Column(name="STREETNAME")
	private String streetName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name="PINCODE")
	private int pinCode;
	
	@OneToOne(mappedBy = "address")
	private User user;

}
