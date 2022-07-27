package br.com.asa.dtos;

import br.com.asa.models.SchoolInformationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationalInformationDto {
	private int id;
	private int alphabetization;
	private int student;
	private Date registerDate;
	private Integer educationalLevel;
	private Integer courseEnroll;
	private Integer courseEnrollSerie;
	private Integer pronatec;
	private Date updateDate;
	private String observation;
	private SchoolInformationEntity schoolInformation;
}