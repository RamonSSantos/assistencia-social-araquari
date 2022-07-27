package br.com.asa.services;

import br.com.asa.dtos.PropertyCharacteristicDto;
import br.com.asa.models.PropertyCharacteristicEntity;
import br.com.asa.repositories.PropertyCharacteristicRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyCharacteristicServiceImpl implements PropertyCharacteristicService{
    private final PropertyCharacteristicRepository propertyCharacteristicRepository;

    @Autowired
    public PropertyCharacteristicServiceImpl(PropertyCharacteristicRepository propertyCharacteristicRepository) {
        this.propertyCharacteristicRepository = propertyCharacteristicRepository;
    }

    @Override
    public Optional<PropertyCharacteristicEntity> findById(Integer id) {
        return this.propertyCharacteristicRepository.findById(id);
    }

    @Override
    public void save(PropertyCharacteristicDto propertyCharacteristicDto) {
        PropertyCharacteristicEntity propertyCharacteristicEntity = new PropertyCharacteristicEntity();
        BeanUtils.copyProperties(propertyCharacteristicDto, propertyCharacteristicEntity);

        this.propertyCharacteristicRepository.save(propertyCharacteristicEntity);
    }

    @Override
    public List<PropertyCharacteristicEntity> findAll() {
        return this.propertyCharacteristicRepository.findAll();
    }
}
