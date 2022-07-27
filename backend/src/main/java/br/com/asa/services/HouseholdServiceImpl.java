package br.com.asa.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.HouseholdDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.asa.models.HouseholdEntity;
import br.com.asa.repositories.HouseholdRepository;

@Service
public class HouseholdServiceImpl implements HouseholdService {
	private final HouseholdRepository householdRepository;
	
	@Autowired
	public HouseholdServiceImpl(HouseholdRepository householdRepository) {
		this.householdRepository = householdRepository;
	}

	@Override
	public Page<HouseholdEntity> findAll(Integer pageNo,Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<HouseholdEntity> pagedResult = this.householdRepository.findAll(paging);

		if(pagedResult.hasContent()) {
			return pagedResult;
		} else {
			return null;
		}
	}

	@Override
	public Optional<HouseholdEntity> findById(Integer id) {
		return this.householdRepository.findById(id);
	}

	@Override
	public List<HouseholdEntity> getByFamilyReferenceName(String search) {
		return this.householdRepository.getByFamilyReferenceName(search);
	}

	@Override
	public void save(HouseholdDto householdDto) {
		HouseholdEntity householdEntity = new HouseholdEntity();
		BeanUtils.copyProperties(householdDto, householdEntity);

		this.householdRepository.save(householdEntity);
	}

	@Override
	public List<HouseholdDto> getChildrenByFamilyId(int familyId) {
		Date minimumDateOfBirth = Date.from(LocalDate.now().minusYears(14).atStartOfDay(ZoneId.systemDefault()).toInstant());

		return this.householdRepository.getChildrenByFamilyId(minimumDateOfBirth, familyId);
	}
}