package br.com.asa.services;

import java.util.Optional;
import br.com.asa.models.AuthenticationEntity;
import br.com.asa.models.UserEntity;

public interface LoginService {
	UserEntity emailValidate(String email);
	void save(AuthenticationEntity authenticationEntity);
	Integer searchToken(String token);
	Optional<UserEntity> findById(Integer id);
	void deleteToken(String token);
}