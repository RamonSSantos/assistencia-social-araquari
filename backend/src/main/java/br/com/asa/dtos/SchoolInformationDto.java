package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolInformationDto {
	private int id;
	private String name;
	private String state;
	private String town;
	private Integer codeInep;
}