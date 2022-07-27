package br.com.asa.services;

import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.asa.models.AuthenticationEntity;
import br.com.asa.models.UserEntity;
import br.com.asa.repositories.AuthenticationRepository;
import br.com.asa.repositories.LoginRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {
	private final LoginRepository loginRepository;
	private final AuthenticationRepository authenticationRepository;
	
	@Autowired
	public LoginServiceImpl(LoginRepository loginRepository, AuthenticationRepository authenticationRepository) {
		this.loginRepository = loginRepository;
		this.authenticationRepository = authenticationRepository;
	}
	
	@Override
	public UserEntity emailValidate(String email) {
		return this.loginRepository.emailValidate(email);
	}
	
	@Override
	public void save(AuthenticationEntity authenticationEntity) {
		this.authenticationRepository.save(authenticationEntity);
	}

	@Override
	public Integer searchToken(String token) {
		return this.authenticationRepository.searchToken(token);
	}
	
	@Override
	public Optional<UserEntity> findById(Integer id) {
		return this.loginRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteToken(String token) {
		this.authenticationRepository.deleteByToken(token);
	}
}