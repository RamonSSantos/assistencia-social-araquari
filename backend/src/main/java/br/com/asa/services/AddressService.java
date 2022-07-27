package br.com.asa.services;

import br.com.asa.dtos.AddressDto;
import br.com.asa.models.AddressEntity;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<AddressEntity> findById(Integer id);
    void save(AddressDto addressDto);
    List<AddressEntity> findAll();
}
