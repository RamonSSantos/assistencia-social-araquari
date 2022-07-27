package br.com.asa.controllers;

import br.com.asa.dtos.PropertyCharacteristicDto;
import br.com.asa.models.PropertyCharacteristicEntity;
import br.com.asa.services.PropertyCharacteristicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "/property-characteristic", method = RequestMethod.GET)
@RestController
public class PropertyCharacteristicController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final PropertyCharacteristicService propertyCharacteristicService;

    @Autowired
    public PropertyCharacteristicController(PropertyCharacteristicService propertyCharacteristicService) {
        this.propertyCharacteristicService = propertyCharacteristicService;
    }

    @GetMapping
    public List<PropertyCharacteristicEntity> getAllPropertiesCharacteristics() { return propertyCharacteristicService.findAll(); }

    @PostMapping(value = "/new")
    public ResponseEntity<String> newPropertyCharacteristic(@RequestBody PropertyCharacteristicDto propertyCharacteristicDto) {
        try {
            propertyCharacteristicService.save(propertyCharacteristicDto);
            return ResponseEntity.status(HttpStatus.OK).body("Condição habitacional registrada com sucesso!");
        }catch(Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<String> editPropertyCharacteristic(@RequestBody PropertyCharacteristicDto propertyCharacteristicDto) {
        try {
            propertyCharacteristicService.save(propertyCharacteristicDto);
            return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso!");
        }catch(Exception exp) {
            logger.error(exp.toString(), exp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OPS! ocorreu um erro inesperado. Tente novamente!");
        }
    }
}
