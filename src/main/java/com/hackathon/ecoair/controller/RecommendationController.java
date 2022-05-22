package com.hackathon.ecoair.controller;

import com.hackathon.ecoair.model.AgentRegistry;
import com.hackathon.ecoair.model.Recommendations;
import com.hackathon.ecoair.model.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
public class RecommendationController {

    @GetMapping(
            value = "/recommendations",
            produces = { HAL_JSON_VALUE }
    )
    public ResponseEntity<Recommendations> getRecommendations(
            HttpServletRequest request){
        //Mock API
        Value points = new Value("Points", "2000");
        Value value = new Value("$", "5");
        List<Value> carbonCompensation = new ArrayList<>();
        carbonCompensation.add(points);
        carbonCompensation.add(value);
        Recommendations recommendations = new Recommendations(carbonCompensation, 100, new ArrayList<>());

        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }

}
