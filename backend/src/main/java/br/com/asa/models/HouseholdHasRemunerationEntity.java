package br.com.asa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "household_has_remuneration")
public class HouseholdHasRemunerationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "remuneration_type")
	private Integer remunerationType;
	
	@Column(name = "amount_received")
	private Float amountReceived;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "household_id", nullable = false)
	@JsonBackReference
	private HouseholdEntity household;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "remuneration_id", nullable = false)
	@JsonBackReference
	private RemunerationEntity remuneration;
}