package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.EducationalInformationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.EducationalInformationEntity;
import br.com.asa.repositories.EducationalInformationRepository;

@Service
public class EducationalInformationServiceImpl implements EducationalInformationService {
	private final EducationalInformationRepository educationalInformationRepository;
	
	@Autowired
	public EducationalInformationServiceImpl(EducationalInformationRepository educationalInformationRepository) {
		this.educationalInformationRepository = educationalInformationRepository;
	}

	@Override
	public Optional<EducationalInformationEntity> findById(Integer id) {
		return this.educationalInformationRepository.findById(id);
	}

	@Override
	public void save(EducationalInformationDto educationalInformationDto) {
		EducationalInformationEntity educationalInformationEntity = new EducationalInformationEntity();
		BeanUtils.copyProperties(educationalInformationDto, educationalInformationEntity);

		this.educationalInformationRepository.save(educationalInformationEntity);
	}

	@Override
	public List<EducationalInformationEntity> findAll() {
		return this.educationalInformationRepository.findAll();
	}
}