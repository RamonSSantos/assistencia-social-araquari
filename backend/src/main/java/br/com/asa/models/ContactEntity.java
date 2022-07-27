package br.com.asa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class ContactEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "primary_phone_type", nullable = false)
	private int primaryPhoneType;
	
	@Column(name = "secondary_phone_type", nullable = false)
	private int secondaryPhoneType;
	
	@Column(name = "email_type", nullable = false)
	private int emailType;
	
	@Column(name = "newsletter", nullable = false)
	private int newsletter;
	
	@Column(name = "message_confirmation", nullable = false)
	private int messageConfirmation;
	
	@Column(name = "primary_phone", length = 15)
	private String primaryPhone;
	
	@Column(name = "secondary_phone", length = 15)
	private String secondaryPhone;
	
	@Column(name = "email")
	private String email;
}