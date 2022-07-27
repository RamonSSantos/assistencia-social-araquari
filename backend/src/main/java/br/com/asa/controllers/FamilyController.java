package br.com.asa.controllers;

import br.com.asa.dtos.FamilyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.FamilyEntity;
import br.com.asa.services.FamilyService;

@RequestMapping(value = "/family-reference", method = RequestMethod.GET)
@RestController
public class FamilyController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final FamilyService familyService;	
		
	@Autowired
	public FamilyController(FamilyService familyService) {
		this.familyService = familyService;
	}
	
	@GetMapping
	public Page<FamilyEntity> getAllFamilies(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "registerDate") String sortBy
	) {
		return this.familyService.getAllFamily(pageNo, pageSize, sortBy);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newFamily(@RequestBody FamilyDto familyDto) {
		try {			
			familyService.save(familyDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editFamily(@RequestBody FamilyDto familyDto) {
		try {			
			familyService.save(familyDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}	
}