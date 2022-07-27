package br.com.asa.services;

import br.com.asa.dtos.AddressDto;
import br.com.asa.models.AddressEntity;
import br.com.asa.repositories.AddressRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<AddressEntity> findById(Integer id) {
        return this.addressRepository.findById(id);
    }

    @Override
    public void save(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(addressDto, addressEntity);

        this.addressRepository.save(addressEntity);
    }

    @Override
    public List<AddressEntity> findAll() {
        return this.addressRepository.findAll();
    }
}
