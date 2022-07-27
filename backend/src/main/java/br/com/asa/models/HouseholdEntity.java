package br.com.asa.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "household")
public class HouseholdEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "fullname", nullable = false)
	private String fullname;
	
	@Column(name = "date_of_birth", nullable = false)
	private Date dateOfBirth;
	
	@Column(name = "genre", nullable = false)
	private String genre;
	
	@Column(name = "family_reference_interaction", nullable = false)
	private int familyReferenceInteraction;
	
	@Column(name = "register_date", nullable = false)
	private Date registerDate;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "race")
	private Integer race;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name ="work_information_id", nullable = false)
	private WorkInformationEntity workInformation;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "civil_documentation_id", nullable = false)
	private CivilDocumentationEntity civilDocumentation;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "educational_information_id", nullable = false)
	private EducationalInformationEntity educationalInformation;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "health_condition_id", nullable = false)
	private HealthConditionEntity healthCondition;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "remuneration_id", nullable = false)
	private RemunerationEntity remuneration;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "family_id")
	private FamilyEntity family;

	@OneToMany(mappedBy = "household", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HouseholdHasRemunerationEntity> householdHasRemuneration = new ArrayList<>();
}