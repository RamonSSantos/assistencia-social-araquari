package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.WorkInformationDto;
import br.com.asa.models.WorkInformationEntity;

public interface WorkInformationService {
	Optional<WorkInformationEntity> findById(Integer id);
	void save(WorkInformationDto workInformationDto);
	List<WorkInformationEntity> findAll();
}