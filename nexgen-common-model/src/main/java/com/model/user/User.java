package com.model.user;


import java.math.BigInteger;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.model.account.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class User {
	
	@Id
	@Column(name = "USERID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "PANCARD")
	private String panCard;

	@Column(name = "AADHARNO")
	private BigInteger aadharNo;

	@Column(name = "PHONENO")
	private BigInteger phoneNo;
	
	@Column(name="KYC")
	private boolean isKycDone;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address address;

	@OneToOne(mappedBy = "user")
	Account account;

	

}
