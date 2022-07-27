package br.com.asa.services;

import java.util.List;
import br.com.asa.models.ProfileEntity;

public interface ProfileService {
	List<ProfileEntity> findAll();
}