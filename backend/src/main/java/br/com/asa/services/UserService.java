package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.UserDto;
import br.com.asa.models.UserEntity;
import org.springframework.data.domain.Page;

public interface UserService {
	Optional<UserEntity> getUserInformationById(Integer id);
	Page<UserEntity> findAll(Integer pageNo, Integer pageSize, String sortBy);
	List<UserEntity> getByUser(String search);
	boolean emailValidation(String email);
	boolean cpfValidation(String cpf);
	void save(UserDto userDto);
	String getEmailById(int id);
}