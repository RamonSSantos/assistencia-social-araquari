package br.com.asa.dtos;

import br.com.asa.models.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int id;
	private String fullname;
	private String cpf;
	private String password;
	private int status;
	private String email;
	private ProfileEntity profile;
}