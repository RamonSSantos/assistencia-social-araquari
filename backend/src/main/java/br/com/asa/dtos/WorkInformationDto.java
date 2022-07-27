package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkInformationDto {
	private int id;
	private int retired;
	private int workLastWeek;
	private int workLastYear;
	private Date registerDate;
	private String jobLocation;
	private String workday;
	private String jobTitle;
	private String professionalQualification;
	private Date updateDate;
	private String observation;
	private Integer monthsWorked;
}