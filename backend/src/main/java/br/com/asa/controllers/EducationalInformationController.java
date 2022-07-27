package br.com.asa.controllers;

import java.util.List;

import br.com.asa.dtos.EducationalInformationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.EducationalInformationEntity;
import br.com.asa.services.EducationalInformationService;

@RequestMapping(value = "/educational-information", method = RequestMethod.GET)
@RestController
public class EducationalInformationController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final EducationalInformationService educationalInformationService;
	
	@Autowired
	public EducationalInformationController(EducationalInformationService educationalInformationService) {
		this.educationalInformationService = educationalInformationService;
	}	
	
	@GetMapping
	public List<EducationalInformationEntity> getAllEducationalInformations() {
		return educationalInformationService.findAll();
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newEducationalInformation(@RequestBody EducationalInformationDto educationalInformationDto) {
		try {
			educationalInformationService.save(educationalInformationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Informações educacionais cadastrada com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}				
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editEducationalInformation(@RequestBody EducationalInformationDto educationalInformationDto) {
		try {
			educationalInformationService.save(educationalInformationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Informações educacionais alterada com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}	
	}
}