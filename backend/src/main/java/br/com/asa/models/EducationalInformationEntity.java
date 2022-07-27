package br.com.asa.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "educational_information")
public class EducationalInformationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "alphabetization", nullable = false)
	private int alphabetization;
	
	@Column(name = "student", nullable = false)
	private int student;

	@Column(name = "register_date", nullable = false)
	private Date registerDate;

	@Column(name = "educational_level")
	private Integer educationalLevel;

	@Column(name = "course_enroll")
	private Integer courseEnroll;
	
	@Column(name = "course_enroll_serie")
	private Integer courseEnrollSerie;
	
	@Column(name = "pronatec")
	private Integer pronatec;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name = "observation")
	private String observation;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "school_information_id")
	private SchoolInformationEntity schoolInformation;
}