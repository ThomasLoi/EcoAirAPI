package com.hackathon.ecoair.api.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ParticipantSearchCriteria {
	
	String type;
	
	String id;
}