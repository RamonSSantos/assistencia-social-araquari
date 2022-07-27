package br.com.asa.services;

import java.util.List;
import java.util.Optional;

import br.com.asa.dtos.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.asa.models.UserEntity;
import br.com.asa.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Optional<UserEntity> getUserInformationById(Integer id) {
		return this.userRepository.getUserInformationById(id);
	}

	@Override
	public Page<UserEntity> findAll(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<UserEntity> pagedResult = this.userRepository.findAll(paging);

		if(pagedResult.hasContent()) {
			return pagedResult;
		} else {
			return null;
		}
	}

	@Override
	public List<UserEntity> getByUser(String search) {
		return this.userRepository.getByUser(search);
	}

	@Override
	public boolean emailValidation(String email) {
		return this.userRepository.emailValidation(email);
	}

	@Override
	public boolean cpfValidation(String cpf) {
		return this.userRepository.cpfValidation(cpf);
	}

	@Override
	public void save(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		this.userRepository.save(userEntity);
	}
	
	@Override
	public String getEmailById(int id) {
		return this.userRepository.getEmailById(id);
	}
}