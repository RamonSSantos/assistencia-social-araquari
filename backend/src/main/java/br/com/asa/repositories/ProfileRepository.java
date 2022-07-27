package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.ProfileEntity;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {}