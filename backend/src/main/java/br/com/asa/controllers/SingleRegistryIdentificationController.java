package br.com.asa.controllers;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.dtos.SingleRegistryIdentificationDto;
import br.com.asa.models.SingleRegistryIdentificationEntity;
import br.com.asa.services.SingleRegistryIdentificationService;

@RequestMapping(value = "/single-registry-identification", method = RequestMethod.GET)
@RestController
public class SingleRegistryIdentificationController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final SingleRegistryIdentificationService singleRegistryIdentificationService;
	
	@Autowired
	public SingleRegistryIdentificationController(SingleRegistryIdentificationService singleRegistryIdentificationService) {
		this.singleRegistryIdentificationService = singleRegistryIdentificationService;
	}
	
	@GetMapping
	public Page<SingleRegistryIdentificationDto> getAllSingleRegistryIdentifications(
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize,
			@RequestParam(defaultValue = "interviewDate") String sortBy
	) {
		if (search == null) {
			return this.singleRegistryIdentificationService.getAll(pageNo - 1, pageSize, sortBy);
		} else {
			return this.singleRegistryIdentificationService.getByHousehold(search, pageNo, pageSize, sortBy);
		}
	}

	@GetMapping(value = "/view/{id}")
	public Optional<SingleRegistryIdentificationEntity> getById(@PathVariable int id) {
		return this.singleRegistryIdentificationService.findById(id);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<String> addSingleRegistryIdentification(@RequestBody SingleRegistryIdentificationDto singleRegistryIdentificationDto) {
		try {
			this.singleRegistryIdentificationService.save(singleRegistryIdentificationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editSingleRegistryIdentification(@RequestBody SingleRegistryIdentificationDto singleRegistryIdentificationDto) {
		try {
			this.singleRegistryIdentificationService.save(singleRegistryIdentificationDto);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}
}