package br.com.asa.controllers;

import br.com.asa.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.asa.encryption.Base64Encryption;
import br.com.asa.encryption.MD5Encryption;
import br.com.asa.models.UserEntity;
import br.com.asa.services.UserService;

import java.util.List;

@RequestMapping(value = "/user", method = RequestMethod.GET)
@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}	
	
	@GetMapping
	public Page<UserEntity> getAllUsers(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "fullname") String sortBy
	) {
		return this.userService.findAll(pageNo - 1, pageSize, sortBy);
	}

	@GetMapping(value = "/search")
	public List<UserEntity> getByUser(@RequestParam String user) {
		return this.userService.getByUser(user);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
		try {
			if(userService.emailValidation(userDto.getEmail())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail já cadastrado. Tente novamente!");
			}

			if(userService.cpfValidation(userDto.getCpf())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado. Tente novamente!");
			}

			Base64Encryption base64Encryption = new Base64Encryption();
			MD5Encryption md5Encryption = new MD5Encryption();
			userDto.setPassword(md5Encryption.encryptPassword(base64Encryption.encodePassword(userDto.getPassword())));
			userDto.setStatus(1);
			userService.save(userDto);
			return ResponseEntity.status(HttpStatus.OK).body("Usuário cadastrado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}		
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> editUser(@RequestBody UserDto userDto) {
		try {
			if(!userService.getEmailById(userDto.getId()).equals(userDto.getEmail())) {
				if(userService.emailValidation(userDto.getEmail())) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail já cadastrado. Tente novamente!");
				}
			}

			userService.save(userDto);
			return ResponseEntity.status(HttpStatus.OK).body("Usuário alterado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
		}
	}
}