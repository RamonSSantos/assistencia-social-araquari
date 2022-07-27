package br.com.asa.services;

import br.com.asa.dtos.PropertyCharacteristicDto;
import br.com.asa.models.PropertyCharacteristicEntity;
import java.util.List;
import java.util.Optional;

public interface PropertyCharacteristicService {
    Optional<PropertyCharacteristicEntity> findById(Integer id);
    void save(PropertyCharacteristicDto propertyCharacteristicDto);
    List<PropertyCharacteristicEntity> findAll();
}
