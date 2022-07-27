package br.com.asa.controllers;

import java.util.List;

import br.com.asa.dtos.RemunerationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.RemunerationEntity;
import br.com.asa.services.RemunerationService;

@RequestMapping(value = "/remuneration", method = RequestMethod.GET)
@RestController
public class RemunerationController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final RemunerationService remunerationService;
	
	@Autowired
	public RemunerationController(RemunerationService remunerationService) {
		this.remunerationService = remunerationService;
	}	
	
	@GetMapping
	public List<RemunerationEntity> getAllRemunerations() {		
		return remunerationService.findAll();
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newRemuneration(@RequestBody RemunerationDto remunerationDto) {
		try {
			this.remunerationService.save(remunerationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}				
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editRemuneration(@RequestBody RemunerationDto remunerationDto) {
		try {
			this.remunerationService.save(remunerationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}	
	}
}