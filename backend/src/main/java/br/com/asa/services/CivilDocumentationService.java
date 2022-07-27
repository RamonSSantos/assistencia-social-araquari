package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.CivilDocumentationDto;
import br.com.asa.models.CivilDocumentationEntity;

public interface CivilDocumentationService {
	Optional<CivilDocumentationEntity> findById(Integer id);
	void save(CivilDocumentationDto civilDocumentationDto);
	List<CivilDocumentationEntity> findAll();
}