package br.com.asa.repositories;

import br.com.asa.models.HouseholdAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdAnswerRepository extends JpaRepository<HouseholdAnswerEntity, Integer> {}