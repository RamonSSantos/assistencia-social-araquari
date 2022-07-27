package br.com.asa.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "remuneration")
public class RemunerationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "type", nullable = false)
	private int type;
	
	@Column(name = "gross_salary", nullable = false)
	private float grossSalary;
	
	@Column(name = "gross_salary_period")
	private Float grossSalaryPeriod;
	
	@Column(name = "continuous_cash_benefit")
	private Integer continuousCashBenefit;

	@OneToMany(mappedBy = "remuneration", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<HouseholdHasRemunerationEntity> householdHasRemuneration = new ArrayList<>();
}