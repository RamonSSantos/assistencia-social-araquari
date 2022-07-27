package br.com.asa.controllers;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.HouseholdDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.HouseholdEntity;
import br.com.asa.services.HouseholdService;

@RequestMapping(value = "/household", method = RequestMethod.GET)
@RestController
public class HouseholdController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final HouseholdService householdService;
	
	@Autowired
	public HouseholdController(HouseholdService householdService) {
		this.householdService = householdService;
	}
	
	@GetMapping
	public Page<HouseholdEntity> getAllFamilyReferences(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "fullname") String sortBy
	) {
		return this.householdService.findAll(pageNo - 1, pageSize, sortBy);
	}

	@GetMapping(value = "/view/{id}")
	public Optional<HouseholdEntity> getById(@PathVariable int id) {
		return householdService.findById(id);
	}

	@GetMapping(value = "/search")
	public List<HouseholdEntity> getByFamilyReferenceName(@RequestParam String familyReference){
		return householdService.getByFamilyReferenceName(familyReference);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<String> newHousehold(@RequestBody HouseholdDto householdDto) {
		try {
			householdService.save(householdDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editHousehold(@RequestBody HouseholdDto householdDto) {
		try {
			householdService.save(householdDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}

	@GetMapping(value = "/view/children/{familyId}")
	public List<HouseholdDto> getChildrenByFamilyId(@PathVariable int familyId) {
		return this.householdService.getChildrenByFamilyId(familyId);
	}
}