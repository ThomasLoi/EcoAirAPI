package com.hackathon.ecoair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.ecoair.api.request.ParticipantSearchCriteria;
import com.hackathon.ecoair.dao.ShipperDao;
import com.hackathon.ecoair.model.AgentRegistry;

@Service
public class ParticipantService {
    @Autowired
    private ShipperDao shipperDao;
    
    public List<AgentRegistry> getShipper(ParticipantSearchCriteria participantSearchCriteria)
    {
        return shipperDao.queryShipper(participantSearchCriteria);
    }
}
