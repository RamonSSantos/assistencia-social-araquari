package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.EducationalInformationEntity;

@Repository
public interface EducationalInformationRepository extends JpaRepository<EducationalInformationEntity, Integer> {}