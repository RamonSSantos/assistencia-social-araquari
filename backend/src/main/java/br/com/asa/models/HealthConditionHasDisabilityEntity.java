package br.com.asa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "health_condition_has_disability")
public class HealthConditionHasDisabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "constant_care")
    private Integer constantCare;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "health_condition_id", nullable = false)
    @JsonBackReference
    private HealthConditionEntity healthCondition;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "disability_id", nullable = false)
    @JsonBackReference
    private DisabilityEntity disability;
}