package com.hackathon.ecoair.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "shipper")
public class ShipperRegistry {
	@JsonProperty("shipperId")
	private int shipperId;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("emission")
	private int emission;
	
	@JsonProperty("donations")
	private double donations;
	
	@JsonProperty("loyaltyPoints")
	private String loyaltyPoints;
}
