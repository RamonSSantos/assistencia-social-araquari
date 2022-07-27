package br.com.asa.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family_answer")
public class FamilyAnswerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "register_date", nullable = false)
	private Date registerDate;
	
	@Column(name = "form_name", nullable = false)
	private String formName;
	
	@Column(name = "json", nullable = false)
	private String json;

	@Column(name = "family_id", nullable = false)
	private int familyId;
}