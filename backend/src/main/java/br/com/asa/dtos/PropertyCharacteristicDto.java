package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCharacteristicDto {
    private int id;
    private int propertySituation;
    private int electricity;
    private int waterSupply;
    private Integer buildingCharacteristic;
    private Float electricityPrice;
    private Float waterSupplyPrice;
    private Integer riskAreaFlood;
    private String propertyObservation;
    private String buildingObservation;
    private Integer sanitarySewer;
    private Integer garbageCollection;
    private Integer rooms;
    private Integer outsideWallCharacteristic;
    private Integer floorCharacteristic;
    private Integer bedrooms;
    private Integer accessibility;
    private Integer riskAreaGeographic;
    private Integer riskAreaConflict;
    private Integer sidewalk;
    private String observation;
}
