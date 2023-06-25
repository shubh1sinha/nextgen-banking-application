package com.model.user;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Value;

import com.model.account.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private String userId;

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
	
	@Column(name="emailId")
	private String emailId;
	
	@Value("false")
	@Column(name="KYC")
	private String isKycDone;
	
	@Value("false")
	@Column(name="UPI")
	private String isupiOpted;
	
	@Value("false")
	@Column(name="DEMAT")
	private String isdematOpted;
	
	@Value("false")
	@Column(name="SALARIED")
	private String isSalariedAccount;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sweep_id", referencedColumnName = "sweepId")
	protected SweepRequested sweepReq;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address address;

	@OneToOne(mappedBy = "user")
	private Account account;

	

}
