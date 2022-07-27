package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.RemunerationDto;
import br.com.asa.models.RemunerationEntity;

public interface RemunerationService {
	Optional<RemunerationEntity> findById(Integer id);
	void save(RemunerationDto remunerationDto);
	List<RemunerationEntity> findAll();
}