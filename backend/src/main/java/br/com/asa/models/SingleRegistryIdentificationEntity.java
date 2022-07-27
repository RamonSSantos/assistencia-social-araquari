package br.com.asa.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "single_registry_identification")
public class SingleRegistryIdentificationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "interview_date", nullable = false)
	private Date interviewDate;
	
	@Column(name = "operation_type")
	private Integer operationType;
	
	@Column(name = "interview_type")
	private Integer interviewType;
	
	@Column(name = "form_type")
	private Integer formType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "observation")
	private String observation;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "family_id", nullable = false)
	private FamilyEntity family;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "subdepartment_id", nullable = false)
	private SubdepartmentEntity subdepartment;
}