package br.com.asa.controllers;

import br.com.asa.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.services.FamilyAnswerService;

@RequestMapping(value = "/family-answers", method = RequestMethod.GET)
@RestController
public class FamilyAnswerController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final FamilyAnswerService familyAnswerService;
	
	@Autowired
	public FamilyAnswerController(FamilyAnswerService familyAnswerService) {
		this.familyAnswerService = familyAnswerService;
	}	
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> addAnswerFamily(@RequestBody FamilyAnswerDto familyAnswerDto) {
		try {			
			familyAnswerService.save(familyAnswerDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");			
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}

	@GetMapping(value = "/monitoring-family/view/{id}")
	public MonitoringFamilyDto getMonitoringFamilyById(@PathVariable("id") int id) {
		return familyAnswerService.getMonitoringFamilyById(id);
	}

	@PostMapping(value = "/monitoring-family/new/family/{familyId}")
	public ResponseEntity<String> addMonitoringFamily(@PathVariable("familyId") int familyId, @RequestBody MonitoringFamilyDto monitoringFamilyDto) {
		try {
			familyAnswerService.newMonitoringFamily(familyId, monitoringFamilyDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}

	@GetMapping(value = "/dispatch-family/view/{id}")
	public DispatchFamilyDto getDispatchFamilyById(@PathVariable("id") int id) {
		return familyAnswerService.getDispatchFamilyById(id);
	}

	@PostMapping(value = "/dispatch-family/new/family/{familyId}")
	public ResponseEntity<String> addDispatchFamily(@PathVariable("familyId") int familyId, @RequestBody DispatchFamilyDto dispatchFamilyDtoFamilyDto) {
		try {
			familyAnswerService.newDispatchFamily(familyId, dispatchFamilyDtoFamilyDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}

	@GetMapping(value = "/age-profile-of-family/view/{id}")
	public AgeProfileOfFamilyDto getAgeProfileOfFamilyById(@PathVariable("id") int id) {
		return familyAnswerService.getAgeProfileOfFamilyById(id);
	}

	@PostMapping(value = "/age-profile-of-family/new/family/{familyId}")
	public ResponseEntity<String> addAgeProfileOfFamily(@PathVariable("familyId") int familyId, @RequestBody AgeProfileOfFamilyDto ageProfileOfFamilyDto) {
		try {
			familyAnswerService.newAgeProfileOfFamily(familyId, ageProfileOfFamilyDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}

	@GetMapping(value = "/first-interview-reason-family/view/{id}")
	public FirstInterviewReasonFamilyDto getFirstInterviewReasonFamilyById(@PathVariable("id") int id) {
		return familyAnswerService.getFirstInterviewReasonFamilyById(id);
	}

	@PostMapping(value = "/first-interview-reason-family/new/family/{familyId}")
	public ResponseEntity<String> addFirstInterviewReasonFamily(@PathVariable("familyId") int familyId, @RequestBody FirstInterviewReasonFamilyDto firstInterviewReasonFamilyDto) {
		try {
			familyAnswerService.newFirstInterviewReasonFamily(familyId, firstInterviewReasonFamilyDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}

	@GetMapping(value = "/single-system-of-social-assistance-family/view/{id}")
	public SingleSystemOfSocialAssistanceFamilyDto getSingleSystemOfSocialAssistanceFamilyById(@PathVariable("id") int id) {
		return familyAnswerService.getSingleSystemOfSocialAssistanceFamilyById(id);
	}

	@PostMapping(value = "/single-system-of-social-assistance-family/new/family/{familyId}")
	public ResponseEntity<String> addSingleSystemOfSocialAssistanceFamily(@PathVariable("familyId") int familyId, @RequestBody SingleSystemOfSocialAssistanceFamilyDto singleSystemOfSocialAssistanceFamilyDto) {
		try {
			familyAnswerService.newSingleSystemOfSocialAssistanceFamily(familyId, singleSystemOfSocialAssistanceFamilyDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<String> editAnswerFamily(@RequestBody FamilyAnswerDto familyAnswerDto) {
		try {			
			familyAnswerService.save(familyAnswerDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");			
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}
}