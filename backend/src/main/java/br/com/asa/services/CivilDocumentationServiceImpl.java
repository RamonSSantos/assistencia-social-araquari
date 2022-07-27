package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.CivilDocumentationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.CivilDocumentationEntity;
import br.com.asa.repositories.CivilDocumentationRepository;

@Service
public class CivilDocumentationServiceImpl implements CivilDocumentationService {
	private final CivilDocumentationRepository civilDocumentationRepository;
	
	@Autowired
	public CivilDocumentationServiceImpl(CivilDocumentationRepository civilDocumentationRepository) {
		this.civilDocumentationRepository = civilDocumentationRepository;
	}

	@Override
	public Optional<CivilDocumentationEntity> findById(Integer id) {
		return this.civilDocumentationRepository.findById(id);
	}

	@Override
	public void save(CivilDocumentationDto civilDocumentationDto) {
		CivilDocumentationEntity civilDocumentationEntity = new CivilDocumentationEntity();
		BeanUtils.copyProperties(civilDocumentationDto, civilDocumentationEntity);

		this.civilDocumentationRepository.save(civilDocumentationEntity);
	}

	@Override
	public List<CivilDocumentationEntity> findAll() {
		return this.civilDocumentationRepository.findAll();
	}
}