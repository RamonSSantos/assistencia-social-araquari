package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicCivilRegistryDto {
	private int id;
	private int certificateType;
	private String registryOffice;
	private Date registerDate;
	private Integer numberBook;
	private Integer entrySheet;
	private Integer rani;
	private String registration;
	private String registerState;
	private String registerTown;
}