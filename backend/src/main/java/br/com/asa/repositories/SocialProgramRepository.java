package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.SocialProgramEntity;

@Repository
public interface SocialProgramRepository extends JpaRepository<SocialProgramEntity, Integer> {}