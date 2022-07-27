package br.com.asa.services;

import java.util.Optional;

import br.com.asa.dtos.FamilyDto;
import br.com.asa.models.FamilyEntity;
import org.springframework.data.domain.Page;

public interface FamilyService {
	Optional<FamilyEntity> findById(Integer id);
	Page<FamilyEntity> getAllFamily(Integer pageNo, Integer pageSize, String sortBy);
	void save(FamilyDto familyDto);
}