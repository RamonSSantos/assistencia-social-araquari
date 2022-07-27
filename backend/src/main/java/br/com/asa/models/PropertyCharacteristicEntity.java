package br.com.asa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "property_characteristic")
public class PropertyCharacteristicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "property_situation", nullable = false)
    private int propertySituation;

    @Column(name = "electricity", nullable = false)
    private int electricity;

    @Column(name = "water_supply", nullable = false)
    private int waterSupply;

    @Column(name = "building_characteristic")
    private Integer buildingCharacteristic;

    @Column(name = "electricity_price")
    private Float electricityPrice;

    @Column(name = "water_supply_price")
    private Float waterSupplyPrice;

    @Column(name = "risk_area_flood")
    private Integer riskAreaFlood;

    @Column(name = "property_observation")
    private String propertyObservation;

    @Column(name = "building_observation")
    private String buildingObservation;

    @Column(name = "sanitary_sewer")
    private Integer sanitarySewer;

    @Column(name = "garbage_collection")
    private Integer garbageCollection;

    @Column(name = "rooms")
    private Integer rooms;

    @Column(name = "outside_wall_characteristic")
    private Integer outsideWallCharacteristic;

    @Column(name = "floor_characteristic")
    private Integer floorCharacteristic;

    @Column(name = "bedrooms")
    private Integer bedrooms;

    @Column(name = "accessibility")
    private Integer accessibility;

    @Column(name = "risk_area_geographic")
    private Integer riskAreaGeographic;

    @Column(name = "risk_area_conflict")
    private Integer riskAreaConflict;

    @Column(name = "sidewalk")
    private Integer sidewalk;

    @Column(name = "observation")
    private String observation;
}
