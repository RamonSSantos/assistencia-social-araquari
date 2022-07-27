package br.com.asa.services;

import br.com.asa.dtos.HouseholdAnswerDto;
import br.com.asa.models.HouseholdAnswerEntity;
import java.util.List;
import java.util.Optional;

public interface HouseholdAnswerService {
    Optional<HouseholdAnswerEntity> findById(Integer id);
    void save(HouseholdAnswerDto householdAnswerDto);
    List<HouseholdAnswerEntity> findAll();
}