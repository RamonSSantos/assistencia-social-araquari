package br.com.asa.models;

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
@Table(name = "place_of_birth")
public class PlaceOfBirthEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "registry_office", nullable = false)
	private int registryOffice;
	
	@Column(name = "hometown")
	private String hometown;
	
	@Column(name = "home_state")
	private String homeState;
	
	@Column(name = "foreign_country")
	private String foreignCountry;
}