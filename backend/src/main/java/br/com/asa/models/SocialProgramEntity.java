package br.com.asa.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "social_program")
public class SocialProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "receive_benefit", nullable = false)
    private int receiveBenefit;

    @Column(name = "family_gross_salary")
    private Float familyGrossSalary;

    @Column(name = "per_capita_income")
    private Float perCapitaIncome;

    @OneToMany(mappedBy = "socialProgram", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FamilyHasSocialProgramEntity> familyHasSocialProgram = new ArrayList<>();
}