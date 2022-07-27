package br.com.asa.controllers;

import br.com.asa.dtos.AddressDto;
import br.com.asa.models.AddressEntity;
import br.com.asa.services.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/address", method = RequestMethod.GET)
@RestController
public class AddressController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressEntity> getAllAddresses() { return addressService.findAll(); }

    @PostMapping(value = "/new")
    public ResponseEntity<String> newAddress(@RequestBody AddressDto addressDto) {
        try {
            addressService.save(addressDto);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço registrado com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<String> editAddress(@RequestBody AddressDto addressDto) {
        try {
            addressService.save(addressDto);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço editado com sucesso!");
        } catch (Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }
}