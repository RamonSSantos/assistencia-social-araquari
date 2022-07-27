package br.com.asa.services;

import java.util.List;

import br.com.asa.dtos.DepartmentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.DepartmentEntity;
import br.com.asa.repositories.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private final DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<DepartmentEntity> findAll() {
		return this.departmentRepository.findAll();
	}

	@Override
	public void save(DepartmentDto departmentDto) {
		DepartmentEntity departmentEntity = new DepartmentEntity();
		BeanUtils.copyProperties(departmentDto, departmentEntity);

		this.departmentRepository.save(departmentEntity);
	}
}