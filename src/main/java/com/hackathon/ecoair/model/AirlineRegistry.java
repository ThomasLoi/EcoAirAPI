package com.hackathon.ecoair.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "airline")
public class AirlineRegistry {
	@JsonProperty("airlineId")
	private int airlineId;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("co2Emission")
	private int emission;
	
	@JsonProperty("carbonCompensation")
	private int carbonCompensation;
	
	@JsonProperty("donations")
	private double donations;
	
	@JsonProperty("badges")
	private String badges;
}
