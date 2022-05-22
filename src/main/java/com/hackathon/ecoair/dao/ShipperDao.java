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
import com.hackathon.ecoair.model.AgentRegistry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShipperDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<AgentRegistry> queryShipper(ParticipantSearchCriteria searchCriteria){

        List<Criteria> criteriaList = new ArrayList<>();
        if(searchCriteria.getType()!= null)
            criteriaList.add(Criteria.where("agentId").is(searchCriteria.getType()));        
//        if(searchCriteria.getId()!= null)
//        	criteriaList.add(Criteria.where("code").is(searchCriteria.getId()) );

        MatchOperation matchOperation = Aggregation.match(criteriaList.get(0));
        ProjectionOperation projectStage = Aggregation.project("agentId","code","name","emission","cargonCompensation","donations","badges");        

        Aggregation aggregation = Aggregation.newAggregation(matchOperation,projectStage);
        AggregationResults<AgentRegistry> result = mongoTemplate.aggregate(aggregation, "agentRegistry" , AgentRegistry.class);
        return result.getMappedResults();
    }
}
