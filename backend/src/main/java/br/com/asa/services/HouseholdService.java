package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.HouseholdDto;
import br.com.asa.models.HouseholdEntity;
import org.springframework.data.domain.Page;

public interface HouseholdService {
	Page<HouseholdEntity> findAll(Integer pageNo, Integer pageSize, String sortBy);
	Optional<HouseholdEntity> findById(Integer id);
	List<HouseholdEntity> getByFamilyReferenceName(String search);
	void save(HouseholdDto householdDto);
	List<HouseholdDto> getChildrenByFamilyId(int familyId);
}