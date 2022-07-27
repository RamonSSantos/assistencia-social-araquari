package br.com.asa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authentication")
public class AuthenticationEntity {
	@Id
	@Column(name = "token", nullable = false)
	private String token;
	
	@Column(name = "user_id", nullable = false)
	private int user;
}