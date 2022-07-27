package br.com.asa.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
	@Query("SELECT COUNT(u.email) > 0 FROM UserEntity u WHERE u.email = :email")
	boolean emailValidation(String email);
	
	@Query("SELECT COUNT(u.cpf) > 0 FROM UserEntity u WHERE u.cpf = :cpf")
	boolean cpfValidation(String cpf);
	
	@Query("SELECT u.email FROM UserEntity u WHERE u.id = :id")
	String getEmailById(int id);
	
	@Query("SELECT u.id, u.fullname, u.email, u.cpf, u.profile, u.status from UserEntity u WHERE u.id = :id")
	Optional<UserEntity> getUserInformationById(int id);

	@Query("SELECT u from UserEntity u WHERE u.fullname LIKE :search%")
	List<UserEntity> getByUser(String search);
}