package com.hackathon.ecoair.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.hackathon.ecoair.api.request.ParticipantSearchCriteria;
import com.hackathon.ecoair.model.ShipperRegistry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShipperDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<ShipperRegistry> queryShipper(ParticipantSearchCriteria searchCriteria){

        List<Criteria> criteriaList = new ArrayList<>();
        if(searchCriteria.getType()!= null)
            criteriaList.add(Criteria.where("participant.properties.https://onerecord-DOTiata-DOTorg/Participant#participantType").is(searchCriteria.getType()));        
        if(searchCriteria.getId()!= null)
        	criteriaList.add(Criteria.where("participant.properties.https://onerecord-DOTiata-DOTorg/Participant#participantId").is(searchCriteria.getId()) );

        MatchOperation matchOperation = Aggregation.match(new Criteria().andOperator(criteriaList.toArray(new Criteria[criteriaList.size()])));
        ProjectionOperation projectStage = Aggregation.project("participant.properties.https://onerecord-DOTiata-DOTorg/Participant#participantId","participant.properties.https://onerecord-DOTiata-DOTorg/Participant#participantName","co2Emissions.calculatedEmissions.value","compensation.value","properties.https://onerecord-DOTiata-DOTorg/Shipment#recommendedLoyaltyPoint");        

        Aggregation aggregation = Aggregation.newAggregation(matchOperation,projectStage);
        AggregationResults<ShipperRegistry> result = mongoTemplate.aggregate(aggregation, "logisticsObject" , ShipperRegistry.class);
        return result.getMappedResults();
    }
}
