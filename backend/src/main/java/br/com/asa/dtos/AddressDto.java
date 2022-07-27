package br.com.asa.dtos;

import br.com.asa.models.FamilyEntity;
import br.com.asa.models.PropertyCharacteristicEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private int id;
    private String street;
    private int number;
    private String districtName;
    private int location;
    private String cep;
    private String complement;
    private String landmark;
    private Integer state;
    private Integer town;
    private Integer districtCode;
    private Integer subdistrict;
    private Integer censusSector;
    private PropertyCharacteristicEntity propertyCharacteristic;
    private Set<FamilyEntity> family = new HashSet<>();
}
