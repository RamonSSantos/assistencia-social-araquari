package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import br.com.asa.models.SingleRegistryIdentificationEntity;
import br.com.asa.dtos.SingleRegistryIdentificationDto;
import br.com.asa.repositories.SingleRegistryIdentificationRepository;

@Service
public class SingleRegistryIdentificationServiceImpl implements SingleRegistryIdentificationService {
	private final SingleRegistryIdentificationRepository singleRegistryIdentificatonRepository;
	
	@Autowired
	public SingleRegistryIdentificationServiceImpl(SingleRegistryIdentificationRepository singleRegistryIdentificatonRepository) {
		this.singleRegistryIdentificatonRepository = singleRegistryIdentificatonRepository;
	}

	@Override
	public Page<SingleRegistryIdentificationDto> getAll(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		List<SingleRegistryIdentificationDto> sriList = this.singleRegistryIdentificatonRepository.getAll();

		long start = paging.getOffset();
		long end = (start + paging.getPageSize()) > sriList.size() ? sriList.size() : (start + paging.getPageSize());
		Page<SingleRegistryIdentificationDto> pagedResult = new PageImpl<>(sriList.subList(Integer.parseInt(String.valueOf(start)),Integer.parseInt(String.valueOf(end))), paging, sriList.size());

		if(pagedResult.hasContent()) {
			return pagedResult;
		} else {
			return null;
		}
	}

	@Override
	public Optional<SingleRegistryIdentificationEntity> findById(Integer id) {		
		return this.singleRegistryIdentificatonRepository.findById(id);
	}
	
	@Override
	public Page<SingleRegistryIdentificationDto> getByHousehold(String search,Integer pageNo,Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		List<SingleRegistryIdentificationDto> sriList = this.singleRegistryIdentificatonRepository.getByHousehold(search);

		long start = paging.getOffset();
		long end = (start + paging.getPageSize()) > sriList.size() ? sriList.size() : (start + paging.getPageSize());
		Page<SingleRegistryIdentificationDto> pagedResult = new PageImpl<>(sriList.subList(Integer.parseInt(String.valueOf(start)),Integer.parseInt(String.valueOf(end))), paging, sriList.size());

		if(pagedResult.hasContent()) {
			return pagedResult;
		} else {
			return null;
		}
	}

	@Override
	public void save(SingleRegistryIdentificationDto singleRegistryIdentificationDto) {
		SingleRegistryIdentificationEntity singleRegistryIdentificationEntity = new SingleRegistryIdentificationEntity();
		BeanUtils.copyProperties(singleRegistryIdentificationDto, singleRegistryIdentificationEntity);

		this.singleRegistryIdentificatonRepository.save(singleRegistryIdentificationEntity);
	}
}