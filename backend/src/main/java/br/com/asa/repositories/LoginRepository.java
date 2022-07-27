package br.com.asa.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.asa.models.UserEntity;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Integer> {
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity emailValidate(String email);
}