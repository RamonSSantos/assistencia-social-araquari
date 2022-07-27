package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.ContactDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.ContactEntity;
import br.com.asa.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	private final ContactRepository contactRepository;
	
	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public Optional<ContactEntity> findById(Integer id) {
		return this.contactRepository.findById(id);
	}

	@Override
	public void save(ContactDto contactDto) {
		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contactDto, contactEntity);

		this.contactRepository.save(contactEntity);
	}

	@Override
	public List<ContactEntity> findAll() { 
		return this.contactRepository.findAll();
	}
}