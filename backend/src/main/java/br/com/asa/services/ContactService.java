package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.ContactDto;
import br.com.asa.models.ContactEntity;

public interface ContactService {
	Optional<ContactEntity> findById(Integer id);
	void save(ContactDto contactDto);
	List<ContactEntity> findAll();
}