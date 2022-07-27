package br.com.asa.dtos;

import br.com.asa.models.HouseholdHasRemunerationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemunerationDto {
	private int id;
	private int type;
	private float grossSalary;
	private Float grossSalaryPeriod;
	private Integer continuousCashBenefit;
	private List<HouseholdHasRemunerationEntity> householdHasRemuneration = new ArrayList<>();
}