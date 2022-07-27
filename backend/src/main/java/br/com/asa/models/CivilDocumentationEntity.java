package br.com.asa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "civil_documentation")
public class CivilDocumentationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "marital_status", nullable = false)
	private int maritalStatus;
	
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@Column(name = "nis", length = 11)
	private String nis;
	
	@Column(name = "senior_card")
	private Integer seniorCard;
	
	@Column(name = "young_card")
	private Integer youngCard;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "filiation_id", nullable = false)
	private FiliationEntity filiation;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "place_of_birth_id", nullable = false)
	private PlaceOfBirthEntity placeOfBirth;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "identity_card_id", nullable = false)
	private IdentityCardEntity identityCard;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "work_card_id", nullable = false)
	private WorkCardEntity workCard;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "electoral_card_id", nullable = false)
	private ElectoralCardEntity electoralCard;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "public_civil_registry_id", nullable = false)
	private PublicCivilRegistryEntity publicCivilRegistry;
}