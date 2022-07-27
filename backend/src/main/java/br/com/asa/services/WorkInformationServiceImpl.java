package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.WorkInformationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.WorkInformationEntity;
import br.com.asa.repositories.WorkInformationRepository;

@Service
public class WorkInformationServiceImpl implements WorkInformationService {
	private final WorkInformationRepository workInformationRepository;
	
	@Autowired
	public WorkInformationServiceImpl(WorkInformationRepository workInformationRepository) {
		this.workInformationRepository = workInformationRepository;
	}

	@Override
	public Optional<WorkInformationEntity> findById(Integer id) {
		return this.workInformationRepository.findById(id);
	}

	@Override
	public void save(WorkInformationDto workInformationDto) {
		WorkInformationEntity workInformationEntity = new WorkInformationEntity();
		BeanUtils.copyProperties(workInformationDto, workInformationEntity);

		this.workInformationRepository.save(workInformationEntity);
	}

	@Override
	public List<WorkInformationEntity> findAll() {
		return this.workInformationRepository.findAll();
	}
}