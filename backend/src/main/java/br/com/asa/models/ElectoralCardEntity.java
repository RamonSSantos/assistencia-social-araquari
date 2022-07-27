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
@Table(name = "electoral_card")
public class ElectoralCardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "number", length = 12)
	private String number;
	
	@Column(name = "electoral_ward", length = 4)
	private String electoralWard;
	
	@Column(name = "electoral_office", length = 4)
	private String electoralOffice;
}