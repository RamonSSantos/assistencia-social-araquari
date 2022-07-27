package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOfBirthDto {
	private int id;
	private int registryOffice;
	private String hometown;
	private String homeState;
	private String foreignCountry;
}