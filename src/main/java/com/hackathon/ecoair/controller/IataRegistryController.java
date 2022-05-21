package com.hackathon.ecoair.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ecoair.model.AgentRegistry;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

@RestController
public class IataRegistryController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	@GetMapping(
			value = "/agent",
			produces = { HAL_JSON_VALUE }
		)
		public ResponseEntity<AgentRegistry> getAgentList(
			HttpServletRequest request){
		return new ResponseEntity<>(OK);
	}
	@GetMapping(
			value = "/agent/{id}",
			produces = { HAL_JSON_VALUE }
			)
	public ResponseEntity<Void> getAgentDetails(
			String id,
			HttpServletRequest request){
		return new ResponseEntity<>(OK);
	}
}