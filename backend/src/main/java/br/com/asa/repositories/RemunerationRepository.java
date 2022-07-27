package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.RemunerationEntity;

@Repository
public interface RemunerationRepository extends JpaRepository<RemunerationEntity, Integer> {}