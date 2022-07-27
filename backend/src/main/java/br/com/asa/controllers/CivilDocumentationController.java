package br.com.asa.controllers;

import java.util.List;

import br.com.asa.dtos.CivilDocumentationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.CivilDocumentationEntity;
import br.com.asa.services.CivilDocumentationService;

@RequestMapping(value = "/civil-documentation", method = RequestMethod.GET)
@RestController
public class CivilDocumentationController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final CivilDocumentationService civilDocumentationService;
	
	@Autowired
	public CivilDocumentationController(CivilDocumentationService civilDocumentationService) {
		this.civilDocumentationService = civilDocumentationService;
	}	
	
	@GetMapping
	public List<CivilDocumentationEntity> getAllCivilDocumentations() {
		return civilDocumentationService.findAll();
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newCivilDocumentation(@RequestBody CivilDocumentationDto civilDocumentationDto) {
		try {
			civilDocumentationService.save(civilDocumentationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}				
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editCivilDocumentation(@RequestBody CivilDocumentationDto civilDocumentationDto) {
		try {
			civilDocumentationService.save(civilDocumentationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");			
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}				
	}
}