package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import br.com.asa.models.AuthenticationEntity;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationEntity, Long> {
	@Query("SELECT a.user FROM AuthenticationEntity a WHERE a.token = :token")
	Integer searchToken(String token);

	@Modifying
	@Query("DELETE FROM AuthenticationEntity a WHERE a.token = :token")
	void deleteByToken(String token);
}