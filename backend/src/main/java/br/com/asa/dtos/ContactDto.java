package br.com.asa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
	private int id;
	private int primaryPhoneType;
	private int secondaryPhoneType;
	private int emailType;
	private int newsletter;
	private int messageConfirmation;
	private String primaryPhone;
	private String secondaryPhone;
	private String email;
}