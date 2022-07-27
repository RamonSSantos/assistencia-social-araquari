package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.HealthConditionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.HealthConditionEntity;
import br.com.asa.repositories.HealthConditionRepository;

@Service
public class HealthConditionServiceImpl implements HealthConditionService {
	private final HealthConditionRepository healthConditionRepository;
	
	@Autowired
	public HealthConditionServiceImpl(HealthConditionRepository healthConditionRepository) {
		this.healthConditionRepository = healthConditionRepository;
	}

	@Override
	public Optional<HealthConditionEntity> findById(Integer id) {
		return this.healthConditionRepository.findById(id);
	}

	@Override
	public void save(HealthConditionDto healthConditionDto) {
		HealthConditionEntity healthConditionEntity = new HealthConditionEntity();
		BeanUtils.copyProperties(healthConditionDto, healthConditionEntity);

		this.healthConditionRepository.save(healthConditionEntity);
	}

	@Override
	public List<HealthConditionEntity> findAll() {
		return this.healthConditionRepository.findAll();
	}
}