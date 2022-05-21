package com.hackathon.ecoair.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "agent")
public class AgentRegistry {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("co2Emission")
	private Integer emission;
	
	@JsonProperty("carbonCompensation")
	private Integer carbonCompensation;
	
	@JsonProperty("donations")
	private Double donations;
	
	@JsonProperty("badges")
	private String badges;
}
