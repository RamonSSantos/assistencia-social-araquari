package br.com.asa.controllers;

import java.util.List;

import br.com.asa.dtos.DepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.DepartmentEntity;
import br.com.asa.services.DepartmentService;

@RequestMapping(value = "/department", method = RequestMethod.GET)
@RestController
public class DepartmentController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping
	public List<DepartmentEntity> getAllDepartments() {
		return departmentService.findAll();
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newDepartment(@RequestBody DepartmentDto departmentDto) {
		try {
			departmentService.save(departmentDto);
			return ResponseEntity.status(HttpStatus.OK).body("Departamento cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}	
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editDepartment(@RequestBody DepartmentDto departmentDto) {
		try {
			departmentService.save(departmentDto);
			return ResponseEntity.status(HttpStatus.OK).body("Departamento alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}	
	}
}