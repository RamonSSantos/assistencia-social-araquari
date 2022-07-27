package br.com.asa.dtos;

import br.com.asa.models.AddressEntity;
import br.com.asa.models.ContactEntity;
import br.com.asa.models.FamilyHasExpenseEntity;
import br.com.asa.models.FamilyHasSocialProgramEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDto {
	private int id;
	private Date registerDate;
	private Float grossSalary;
	private Float perCapitaIncome;
	private String helthcareCenter;
	private Integer foodInsecuritySituation;
	private String ethnicity;
	private String community;
	private String indianVillage;
	private Integer hospitalizedPerson;
	private String familyCode;
	private Integer childLabour;
	private Date updateDate;
	private String observation;
	private ContactEntity contact;
	private Set<AddressEntity> address = new HashSet<>();
	private List<FamilyHasSocialProgramEntity> familyHasSocialProgram = new ArrayList<>();
	private List<FamilyHasExpenseEntity> familyHasExpense = new ArrayList<>();
}