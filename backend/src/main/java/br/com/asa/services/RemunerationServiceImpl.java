package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.RemunerationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.RemunerationEntity;
import br.com.asa.repositories.RemunerationRepository;

@Service
public class RemunerationServiceImpl implements RemunerationService {
	private final RemunerationRepository remunerationRepository;
	
	@Autowired
	public RemunerationServiceImpl(RemunerationRepository remunerationRepository) {
		this.remunerationRepository = remunerationRepository;
	}

	@Override
	public Optional<RemunerationEntity> findById(Integer id) {
		return this.remunerationRepository.findById(id);
	}

	@Override
	public void save(RemunerationDto remunerationDto) {
		RemunerationEntity remunerationEntity = new RemunerationEntity();
		BeanUtils.copyProperties(remunerationDto, remunerationEntity);

		this.remunerationRepository.save(remunerationEntity);
	}

	@Override
	public List<RemunerationEntity> findAll() {
		return this.remunerationRepository.findAll();
	}	
}