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
@Table(name = "identity_card")
public class IdentityCardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "number")
	private Long number;
	
	@Column(name = "complement", length = 5)
	private String complement;
	
	@Column(name = "issuing_date")
	private Date issuingDate;
	
	@Column(name = "issuing_state")
	private String issuingState;
	
	@Column(name = "issuing_state_initial", length = 8)
	private String issuingStateInitial;
}