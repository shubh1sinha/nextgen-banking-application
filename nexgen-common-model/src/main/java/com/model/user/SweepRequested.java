package com.model.user;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="SWEEP_REQUESTED")
public class SweepRequested {
	
	@Column(name="SWEEPID")
	private String sweepId;
	
	@Value("false")
	@Column(name = "OPTED")
	private String isSweepOpted;
	
	@Column(name=  "PERCENTAGE")
	private double percentage;
	
	@OneToOne(mappedBy = "sweepReq")
	private User user;
	

}
