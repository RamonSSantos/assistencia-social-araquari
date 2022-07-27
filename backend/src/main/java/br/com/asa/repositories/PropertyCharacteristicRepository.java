package br.com.asa.repositories;

import br.com.asa.models.PropertyCharacteristicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyCharacteristicRepository extends JpaRepository<PropertyCharacteristicEntity, Integer> {}
