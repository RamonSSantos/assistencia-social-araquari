package br.com.asa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import br.com.asa.services.LoginService;
import br.com.asa.services.UserService;
import br.com.asa.encryption.Base64Encryption;
import br.com.asa.encryption.MD5Encryption;
import br.com.asa.models.AuthenticationEntity;
import br.com.asa.models.UserEntity;

@RestController
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final LoginService loginService;
	private final UserService userService;
	
	@Autowired
	public LoginController(LoginService loginService, UserService userService) {
		this.loginService = loginService;
		this.userService = userService;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserEntity userEntity) {
		try {
			UserEntity userDb = loginService.emailValidate(userEntity.getEmail());
			if(userDb == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail ou senha incorretos!");
			}

			if(userDb.getStatus() != 1) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado. Entre em contato com o administrador!");
			}

			Base64Encryption base64Encryption = new Base64Encryption();
			MD5Encryption md5Encryption = new MD5Encryption();
			if(!userDb.getPassword().equals(md5Encryption.encryptPassword(base64Encryption.encodePassword(userEntity.getPassword())))) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail ou senha incorretos!");
			}

			AuthenticationEntity authenticationEntity = new AuthenticationEntity();
			authenticationEntity.setToken(UUID.randomUUID().toString());
			authenticationEntity.setUser(userDb.getId());
			loginService.save(authenticationEntity);
			return ResponseEntity.status(HttpStatus.OK).body(authenticationEntity);
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! Ocorreu um erro inesperado.");
		}
	}

	@GetMapping(value = "/load-session")
	public ResponseEntity<?> loadSession(HttpServletRequest httpServletRequest) {
		try {
			String bearerToken = httpServletRequest.getHeader("Authorization");
			if (bearerToken == null || !bearerToken.startsWith("Bearer ")){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível carregar a sessão do usuário!");
			}

			String token = bearerToken.substring(7);
			Integer id = loginService.searchToken(token);
			return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInformationById(id));
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! Ocorreu um erro inesperado.");
		}
	}

	@DeleteMapping(value = "/logout")
	public ResponseEntity<?> logout(HttpServletRequest httpServletRequest){
		try {
			String bearerToken = httpServletRequest.getHeader("Authorization");
			if (bearerToken == null || !bearerToken.startsWith("Bearer ")){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível carregar a sessão do usuário!");
			}

			String token = bearerToken.substring(7);

			loginService.deleteToken(token);
			return ResponseEntity.status(HttpStatus.OK).body("Logout realizado com sucesso!");
		}catch(Exception exp) {
			logger.error(exp.toString(), exp);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! Ocorreu um erro inesperado.");
		}
	}
}