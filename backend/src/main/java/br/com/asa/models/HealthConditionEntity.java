package br.com.asa.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "health_condition")
public class HealthConditionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "register_date", nullable = false)
	private Date registerDate;
	
	@Column(name = "reference_care")
	private String referenceCare;
	
	@Column(name = "serious_illness")
	private String seriousIllness;
	
	@Column(name = "prescription_medication")
	private String prescriptionMedication;
	
	@Column(name = "alcoholic")
	private String alcoholic;
	
	@Column(name = "drug_addict")
	private String drugAddict;
	
	@Column(name = "pregnancy")
	private Integer pregnancy;
	
	@Column(name = "antenatal_visit")
	private Integer antenatalVisit;
	
	@Column(name = "contraceptive_method")
	private String contraceptiveMethod;
	
	@Column(name = "chronic_disease")
	private String chronicDisease;
	
	@Column(name = "free_pass")
	private Integer freePass;
	
	@Column(name = "observation")
	private String observation;

	@OneToMany(mappedBy = "healthCondition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HealthConditionHasDisabilityEntity> healthConditionHasDisability = new ArrayList<>();
}