package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdentityCardDto {
	private int id;
	private Long number;
	private String complement;
	private Date issuingDate;
	private String issuingState;
	private String issuingStateInitial;
}