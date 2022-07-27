package br.com.asa.controllers;

import java.util.List;

import br.com.asa.dtos.HealthConditionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.HealthConditionEntity;
import br.com.asa.services.HealthConditionService;

@RequestMapping(value = "/health-condition", method = RequestMethod.GET)
@RestController
public class HealthConditionController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final HealthConditionService healthConditionService;
	
	@Autowired
	public HealthConditionController(HealthConditionService healthConditionService) {
		this.healthConditionService = healthConditionService;
	}	
	
	@GetMapping
	public List<HealthConditionEntity> getAllHealthConditions() {
		return healthConditionService.findAll();
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newHealthCondition(@RequestBody HealthConditionDto healthConditionDto) {
		try {
			healthConditionService.save(healthConditionDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}				
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editHealthCondition(@RequestBody HealthConditionDto healthConditionDto) {
		try {
			healthConditionService.save(healthConditionDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}
}