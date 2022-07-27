package br.com.asa.dtos;

import br.com.asa.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CivilDocumentationDto {
	private int id;
	private int maritalStatus;
	private String cpf;
	private String nis;
	private Integer seniorCard;
	private Integer youngCard;
	private FiliationEntity filiation;
	private PlaceOfBirthEntity placeOfBirth;
	private IdentityCardEntity identityCard;
	private WorkCardEntity workCard;
	private ElectoralCardEntity electoralCard;
	private PublicCivilRegistryEntity publicCivilRegistry;
}