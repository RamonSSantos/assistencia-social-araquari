package br.com.asa.services;

import br.com.asa.dtos.SubdepartmentDto;
import org.springframework.data.domain.Page;
import java.util.List;

public interface SubdepartmentService {
	Page<SubdepartmentDto> findAll(Integer pageNo, Integer pageSize, String sortBy);
	List<SubdepartmentDto> getBySubdepartment(String search);
	void save(SubdepartmentDto subdepartmentDto);
}