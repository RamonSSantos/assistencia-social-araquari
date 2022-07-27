package br.com.asa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "household_answer")
public class HouseholdAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "register_date", nullable = false)
    private Date registerDate;

    @Column(name = "form_name", nullable = false)
    private String formName;

    @Column(name = "json", nullable = false)
    private String json;

    @Column(name = "household_id", nullable = false)
    private int householdId;
}