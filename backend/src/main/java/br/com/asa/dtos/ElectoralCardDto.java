package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectoralCardDto {
	private int id;
	private String number;
	private String electoralWard;
	private String electoralOffice;
}