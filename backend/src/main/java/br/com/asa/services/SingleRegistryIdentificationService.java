package br.com.asa.services;

import java.util.Optional;
import br.com.asa.models.SingleRegistryIdentificationEntity;
import br.com.asa.dtos.SingleRegistryIdentificationDto;
import org.springframework.data.domain.Page;

public interface SingleRegistryIdentificationService {
	Page<SingleRegistryIdentificationDto> getAll(Integer pageNo, Integer pageSize, String sortBy);
	Optional<SingleRegistryIdentificationEntity> findById(Integer id);
	Page<SingleRegistryIdentificationDto> getByHousehold(String search, Integer pageNo, Integer pageSize, String sortBy);
	void save(SingleRegistryIdentificationDto singleRegistryIdentificationDto);
}