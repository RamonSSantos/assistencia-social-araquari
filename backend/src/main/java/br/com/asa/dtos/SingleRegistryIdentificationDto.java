package br.com.asa.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingleRegistryIdentificationDto {
	private int id;
	private Date interviewDate;
	private String fullnameUser;
	private String description;
	private String fullnameHousehold;
	private Date dateOfBirth;
	private String genre;
	private int retired;
	private int maritalStatus;
}