package br.com.asa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "fullname", nullable = false)
	private String fullname;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "profile_id", nullable = false)
	private ProfileEntity profile;
}