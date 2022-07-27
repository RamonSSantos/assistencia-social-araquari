package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.CivilDocumentationEntity;

@Repository
public interface CivilDocumentationRepository extends JpaRepository<CivilDocumentationEntity, Integer> {}