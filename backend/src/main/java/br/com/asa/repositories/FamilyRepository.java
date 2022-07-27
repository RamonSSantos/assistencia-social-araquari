package br.com.asa.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.FamilyEntity;

@Repository
public interface FamilyRepository extends PagingAndSortingRepository<FamilyEntity, Integer> {}