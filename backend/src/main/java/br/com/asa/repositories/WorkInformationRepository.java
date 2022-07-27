package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.WorkInformationEntity;

@Repository
public interface WorkInformationRepository extends JpaRepository<WorkInformationEntity, Integer> {}