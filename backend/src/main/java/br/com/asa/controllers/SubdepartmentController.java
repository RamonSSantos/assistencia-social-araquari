package br.com.asa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.dtos.SubdepartmentDto;
import br.com.asa.services.SubdepartmentService;
import java.util.List;

@RequestMapping(value = "/subdepartment", method = RequestMethod.GET)
@RestController
public class SubdepartmentController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final SubdepartmentService subdepartmentService;
	
	@Autowired
	public SubdepartmentController(SubdepartmentService subdepartmentService) {
		this.subdepartmentService = subdepartmentService;
	}
	
	@GetMapping
	public Page<SubdepartmentDto> getAllSubdepartments(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "description") String sortBy
	) {
		return this.subdepartmentService.findAll(pageNo - 1, pageSize, sortBy);
	}

	@GetMapping(value = "/search")
	public List<SubdepartmentDto> getBySubdepartment(@RequestParam String subdepartment) {
		return this.subdepartmentService.getBySubdepartment(subdepartment);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newSubdepartment(@RequestBody SubdepartmentDto subdepartmentDto) {
		try {
			subdepartmentService.save(subdepartmentDto);
			return ResponseEntity.status(HttpStatus.OK).body("Equipamento cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}	
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editSubdepartment(@RequestBody SubdepartmentDto subdepartmentDto) {
		try {
			subdepartmentService.save(subdepartmentDto);
			return ResponseEntity.status(HttpStatus.OK).body("Equipamento alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}	
	}
}