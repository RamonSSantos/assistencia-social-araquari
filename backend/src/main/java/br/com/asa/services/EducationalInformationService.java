package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.EducationalInformationDto;
import br.com.asa.models.EducationalInformationEntity;

public interface EducationalInformationService {
	Optional<EducationalInformationEntity> findById(Integer id);
	void save(EducationalInformationDto educationalInformationDto);
	List<EducationalInformationEntity> findAll();
}