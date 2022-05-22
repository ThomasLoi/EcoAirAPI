package com.hackathon.ecoair.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ShipperRegistry {
	@JsonProperty("participant.properties.https://onerecord-DOTiata-DOTorg/Participant#participantId")
	private int shipperId;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("participant.properties.https://onerecord-DOTiata-DOTorg/Participant#participantName")
	private String name;
	
	@JsonProperty("co2Emissions.calculatedEmissions.value")
	private int emission;
	
	@JsonProperty("compensation.value")
	private double donations;
	
	@JsonProperty("properties.https://onerecord-DOTiata-DOTorg/Shipment#recommendedLoyaltyPoint")
	private String loyaltyPoints;
}
