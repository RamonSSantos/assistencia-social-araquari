package br.com.asa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.asa.models.ProfileEntity;
import br.com.asa.repositories.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	private final ProfileRepository profileRepository;
	
	@Autowired
	public ProfileServiceImpl(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}
	
	@Override
	public List<ProfileEntity> findAll() {
		return this.profileRepository.findAll();
	}
}