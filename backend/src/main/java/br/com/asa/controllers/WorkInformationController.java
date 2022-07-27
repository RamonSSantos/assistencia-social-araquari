package br.com.asa.controllers;

import java.util.List;

import br.com.asa.dtos.WorkInformationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.WorkInformationEntity;
import br.com.asa.services.WorkInformationService;

@RequestMapping(value = "/work-information", method = RequestMethod.GET)
@RestController
public class WorkInformationController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final WorkInformationService workInformationService;
	
	@Autowired
	public WorkInformationController(WorkInformationService workInformationService) {
		this.workInformationService = workInformationService;
	}	
	
	@GetMapping
	public List<WorkInformationEntity> getAllWorkInformations() {		
		return workInformationService.findAll();
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> addWorkInformation(@RequestBody WorkInformationDto workInformationDto) {
		try {
			this.workInformationService.save(workInformationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Informações de trabalho cadastrada com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editWorkInformation(@RequestBody WorkInformationDto workInformationDto) {
		try {
			this.workInformationService.save(workInformationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Informações de trabalho alterada com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}
}