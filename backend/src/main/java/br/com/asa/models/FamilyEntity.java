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
@Table(name = "family")
public class FamilyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "register_date", nullable = false)
	private Date registerDate;
	
	@Column(name = "family_gross_salary")
	private Float grossSalary;
	
	@Column(name = "per_capita_income")
	private Float perCapitaIncome;
	
	@Column(name = "helthcare_center")
	private String helthcareCenter;
	
	@Column(name = "food_insecurity_situation")
	private Integer foodInsecuritySituation;
	
	@Column(name = "ethnicity")
	private String ethnicity;
	
	@Column(name = "community")
	private String community;
	
	@Column(name = "indian_village")
	private String indianVillage;
	
	@Column(name = "hospitalized_person")
	private Integer hospitalizedPerson;

	@Column(name = "family_code", length = 11)
	private String familyCode;

	@Column(name = "child_labour")
	private Integer childLabour;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name = "observation")
	private String observation;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "contact_id", nullable = false)
	private ContactEntity contact;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "family_has_address",
			joinColumns = { @JoinColumn(name = "family_id") },
			inverseJoinColumns = { @JoinColumn(name = "address_id") })
	private Set<AddressEntity> address = new HashSet<>();

	@OneToMany(mappedBy = "family", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FamilyHasSocialProgramEntity> familyHasSocialProgram = new ArrayList<>();

	@OneToMany(mappedBy = "family", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FamilyHasExpenseEntity> familyHasExpense = new ArrayList<>();
}