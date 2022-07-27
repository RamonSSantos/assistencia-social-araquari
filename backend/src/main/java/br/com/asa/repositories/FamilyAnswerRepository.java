package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.asa.models.FamilyAnswerEntity;

@Repository
public interface FamilyAnswerRepository extends JpaRepository<FamilyAnswerEntity, Integer> {}
