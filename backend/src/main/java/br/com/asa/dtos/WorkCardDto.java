package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkCardDto {
	private int id;
	private String number;
	private String serie;
	private Date issuingDate;
	private String issuingState;
}