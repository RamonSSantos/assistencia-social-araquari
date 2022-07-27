package br.com.asa.repositories;

import br.com.asa.dtos.SingleRegistryIdentificationDto;
import br.com.asa.models.SingleRegistryIdentificationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingleRegistryIdentificationRepository extends PagingAndSortingRepository<SingleRegistryIdentificationEntity, Integer> {
	@Query("SELECT new br.com.asa.dtos.SingleRegistryIdentificationDto("
			+ "sri.id, "
			+ "sri.interviewDate, "
			+ "u.fullname, "
			+ "s.description, "
			+ "h.fullname, "
			+ "h.dateOfBirth, "
			+ "h.genre, "
			+ "wi.retired, "
			+ "cd.maritalStatus) "
			+ "FROM SingleRegistryIdentificationEntity sri "
			+ "INNER JOIN UserEntity u ON u.id = sri.user "
			+ "INNER JOIN SubdepartmentEntity s ON s.id = sri.subdepartment "
			+ "INNER JOIN FamilyEntity f ON f.id = sri.family "
			+ "INNER JOIN HouseholdEntity h ON h.family = f.id "
			+ "INNER JOIN WorkInformationEntity wi ON wi.id = h.workInformation "
			+ "INNER JOIN CivilDocumentationEntity cd ON cd.id = h.civilDocumentation "
			+ "WHERE h.familyReferenceInteraction = 1")
	List<SingleRegistryIdentificationDto> getAll();

	@Query("SELECT new br.com.asa.dtos.SingleRegistryIdentificationDto("
			+ "sri.id, "
			+ "sri.interviewDate, "
			+ "u.fullname, "
			+ "s.description, "
			+ "h.fullname, "
			+ "h.dateOfBirth, "
			+ "h.genre, "
			+ "wi.retired, "
			+ "cd.maritalStatus) "
			+ "FROM SingleRegistryIdentificationEntity sri "
			+ "INNER JOIN UserEntity u ON u.id = sri.user "
			+ "INNER JOIN SubdepartmentEntity s ON s.id = sri.subdepartment "
			+ "INNER JOIN FamilyEntity f ON f.id = sri.family "
			+ "INNER JOIN HouseholdEntity h ON h.family = f.id "
			+ "INNER JOIN WorkInformationEntity wi ON wi.id = h.workInformation "
			+ "INNER JOIN CivilDocumentationEntity cd ON cd.id = h.civilDocumentation "
			+ "WHERE h.fullname LIKE :search%")
	List<SingleRegistryIdentificationDto> getByHousehold(String search);
}