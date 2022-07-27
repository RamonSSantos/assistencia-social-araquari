package br.com.asa.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "public_civil_registry")
public class PublicCivilRegistryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "certificate_type", nullable = false)
	private int certificateType;
	
	@Column(name = "registry_office")
	private String registryOffice;
	
	@Column(name = "register_date")
	private Date registerDate;
	
	@Column(name = "number_book", length = 8)
	private Integer numberBook;
	
	@Column(name = "entry_sheet", length = 4)
	private Integer entrySheet;
	
	@Column(name = "rani", length = 8)
	private Integer rani;
	
	@Column(name = "registration")
	private String registration;
	
	@Column(name = "register_state")
	private String registerState;
	
	@Column(name = "register_town")
	private String registerTown;
}