package br.com.asa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "district_name", nullable = false)
    private String districtName;

    @Column(name = "location", nullable = false)
    private int location;

    @Column(name = "cep", length = 9)
    private String cep;

    @Column(name = "complement")
    private String complement;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "state", length = 2)
    private Integer state;

    @Column(name = "town", length = 5)
    private Integer town;

    @Column(name = "district_code", length = 2)
    private Integer districtCode;

    @Column(name = "subdistrict", length = 2)
    private Integer subdistrict;

    @Column(name = "census_sector", length = 4)
    private Integer censusSector;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "property_characteristic_id", nullable = false)
    private PropertyCharacteristicEntity propertyCharacteristic;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "address")
    private Set<FamilyEntity> family = new HashSet<>();
}
