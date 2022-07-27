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
@Table(name = "work_information")
public class WorkInformationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "retired", nullable = false)
	private int retired;
	
	@Column(name = "work_last_week", nullable = false)
	private int workLastWeek;
	
	@Column(name = "work_last_year", nullable = false)
	private int workLastYear;
	
	@Column(name = "register_date", nullable = false)
	private Date registerDate;
	
	@Column(name = "job_location")
	private String jobLocation;
	
	@Column(name = "workday")
	private String workday;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "professional_qualification")
	private String professionalQualification;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "months_worked")
	private Integer monthsWorked;
}