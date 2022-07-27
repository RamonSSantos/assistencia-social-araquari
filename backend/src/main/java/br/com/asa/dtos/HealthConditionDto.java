package br.com.asa.dtos;

import br.com.asa.models.HealthConditionHasDisabilityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthConditionDto {
	private int id;
	private Date registerDate;
	private String referenceCare;
	private String seriousIllness;
	private String prescriptionMedication;
	private String alcoholic;
	private String drugAddict;
	private Integer pregnancy;
	private Integer antenatalVisit;
	private String contraceptiveMethod;
	private String chronicDisease;
	private Integer freePass;
	private String observation;
	private List<HealthConditionHasDisabilityEntity> healthConditionHasDisability = new ArrayList<>();
}