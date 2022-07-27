package br.com.asa.services;

import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import br.com.asa.dtos.SubdepartmentDto;
import br.com.asa.models.SubdepartmentEntity;
import br.com.asa.repositories.SubdepartmentRepository;

@Service
public class SubdepartmentServiceImpl implements SubdepartmentService {
	private final SubdepartmentRepository subdepartmentRepository;
	
	@Autowired
	public SubdepartmentServiceImpl(SubdepartmentRepository subDepartmentRepository) {
		this.subdepartmentRepository = subDepartmentRepository;
	}

	@Override
	public Page<SubdepartmentDto> findAll(Integer pageNo,Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<SubdepartmentEntity> pagedResult = this.subdepartmentRepository.findAll(paging);

		Type pageType = new TypeToken<Page<SubdepartmentDto>>() {}.getType();
		Page<SubdepartmentDto> subdepartmentDto = new ModelMapper().map(pagedResult, pageType);

		if(subdepartmentDto.hasContent()) {
			return subdepartmentDto;
		} else {
			return null;
		}
	}

	@Override
	public List<SubdepartmentDto> getBySubdepartment(String search) {
		List<SubdepartmentEntity> subdepartmentEntity = this.subdepartmentRepository.getBySubdepartment(search);

		Type listType = new TypeToken<List<SubdepartmentDto>>() {}.getType();
		return new ModelMapper().map(subdepartmentEntity, listType);
	}

	@Override
	public void save(SubdepartmentDto subdepartmentDto) {
		SubdepartmentEntity subdepartmentEntity = new SubdepartmentEntity();
		BeanUtils.copyProperties(subdepartmentDto, subdepartmentEntity);

		this.subdepartmentRepository.save(subdepartmentEntity);
	}
}