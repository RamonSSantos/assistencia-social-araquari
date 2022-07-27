package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyAnswerDto {
	private int id;
	private Date registerDate;
	private String formName;
	private String json;
	private int familyId;
}