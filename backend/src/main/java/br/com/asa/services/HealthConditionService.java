package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.HealthConditionDto;
import br.com.asa.models.HealthConditionEntity;

public interface HealthConditionService {
	Optional<HealthConditionEntity> findById(Integer id);
	void save(HealthConditionDto healthConditionDto);
	List<HealthConditionEntity> findAll();
}