package com.model.user;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "USER_ATTRIBUTES")
public class UserAttributes {
	
	@Id
	@Column(name="ATTRIBUTES_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attributesId;
	
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
	
	@OneToOne(mappedBy = "userAttributes")
	private User user;

}
