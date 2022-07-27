package br.com.asa.services;

import java.util.List;

import br.com.asa.dtos.DepartmentDto;
import br.com.asa.models.DepartmentEntity;

public interface DepartmentService {
	List<DepartmentEntity> findAll();
	void save(DepartmentDto departmentDto);
}