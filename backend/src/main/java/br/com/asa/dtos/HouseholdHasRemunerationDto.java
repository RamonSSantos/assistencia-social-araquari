package br.com.asa.dtos;

import br.com.asa.models.HouseholdEntity;
import br.com.asa.models.RemunerationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdHasRemunerationDto {
	private int id;
	private Integer remunerationType;
	private Float amountReceived;
	private HouseholdEntity household;
	private RemunerationEntity remuneration;
}