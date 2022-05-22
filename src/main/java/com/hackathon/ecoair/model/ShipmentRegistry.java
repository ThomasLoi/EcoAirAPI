package com.hackathon.ecoair.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "participant.properties.https://onerecord-DOTiata-DOTorg/Participant#participant")
public class ShipmentRegistry {
	@JsonProperty("shipmentId")
	private int shipmentId;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("name")
	private String name;
}
