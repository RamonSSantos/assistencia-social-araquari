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
@Table(name = "family_has_social_program")
public class FamilyHasSocialProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "program_type")
    private Integer programType;

    @Column(name = "amount_received")
    private Float amountReceived;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    @JsonBackReference
    private FamilyEntity family;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "social_program_id", nullable = false)
    @JsonBackReference
    private ExpenseEntity socialProgram;
}
