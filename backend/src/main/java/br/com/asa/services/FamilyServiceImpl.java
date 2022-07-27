package br.com.asa.services;

import java.util.Optional;

import br.com.asa.dtos.FamilyDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.asa.models.FamilyEntity;
import br.com.asa.repositories.FamilyRepository;

@Service
public class FamilyServiceImpl implements FamilyService {
	private final FamilyRepository familyRepository;
	
	@Autowired
	public FamilyServiceImpl(FamilyRepository familyRepository) {
		this.familyRepository = familyRepository;
	}

	@Override
	public Optional<FamilyEntity> findById(Integer id) {
		return this.familyRepository.findById(id);
	}

	@Override
	public Page<FamilyEntity> getAllFamily(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<FamilyEntity> pagedResult = this.familyRepository.findAll(paging);

		if(pagedResult.hasContent()) {
			return pagedResult;
		} else {
			return null;
		}
	}

	@Override
	public void save(FamilyDto familyDto) {
		FamilyEntity familyEntity = new FamilyEntity();
		BeanUtils.copyProperties(familyDto, familyEntity);

		this.familyRepository.save(familyEntity);
	}
}