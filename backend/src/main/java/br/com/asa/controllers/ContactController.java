package br.com.asa.controllers;

import java.util.List;

import br.com.asa.dtos.ContactDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.models.ContactEntity;
import br.com.asa.services.ContactService;

@RequestMapping(value = "/contact", method = RequestMethod.GET)
@RestController
public class ContactController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping
	public List<ContactEntity> getAllContacts() {
		return contactService.findAll();
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> newContact(@RequestBody ContactDto contactDto) {
		try {
			contactService.save(contactDto);
			return ResponseEntity.status(HttpStatus.OK).body("Contato cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<String> editContact(@RequestBody ContactDto contactDto) {
		try {
			contactService.save(contactDto);
			return ResponseEntity.status(HttpStatus.OK).body("Contato alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}
}