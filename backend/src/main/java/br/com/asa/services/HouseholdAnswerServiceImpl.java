package br.com.asa.services;

import br.com.asa.dtos.HouseholdAnswerDto;
import br.com.asa.models.HouseholdAnswerEntity;
import br.com.asa.repositories.HouseholdAnswerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HouseholdAnswerServiceImpl implements HouseholdAnswerService {
    private final HouseholdAnswerRepository householdAnswerRepository;

    @Autowired
    public HouseholdAnswerServiceImpl(HouseholdAnswerRepository householdAnswerRepository) {
        this.householdAnswerRepository = householdAnswerRepository;
    }

    @Override
    public Optional<HouseholdAnswerEntity> findById(Integer id) {
        return this.householdAnswerRepository.findById(id);
    }

    @Override
    public void save(HouseholdAnswerDto householdAnswerDto) {
        HouseholdAnswerEntity householdAnswerEntity = new HouseholdAnswerEntity();
        BeanUtils.copyProperties(householdAnswerDto, householdAnswerEntity);

        this.householdAnswerRepository.save(householdAnswerEntity);
    }

    @Override
    public List<HouseholdAnswerEntity> findAll() {
        return this.householdAnswerRepository.findAll();
    }
}