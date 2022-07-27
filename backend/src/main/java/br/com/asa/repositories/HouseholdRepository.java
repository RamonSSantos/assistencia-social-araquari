package br.com.asa.repositories;

import br.com.asa.dtos.HouseholdDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.HouseholdEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface HouseholdRepository extends PagingAndSortingRepository<HouseholdEntity, Integer> {
    @Query("SELECT h FROM HouseholdEntity h WHERE h.familyReferenceInteraction = 1")
    List<HouseholdEntity> findAllByFamilyReference();

    @Query("SELECT h FROM HouseholdEntity h WHERE h.familyReferenceInteraction = 1 AND h.fullname LIKE :search%")
    List<HouseholdEntity> getByFamilyReferenceName(String search);

    @Query("SELECT new br.com.asa.dtos.HouseholdDto(h.id, h.fullname) FROM HouseholdEntity h "
            + "INNER JOIN FamilyEntity f on f.id = h.family "
            + "WHERE h.dateOfBirth >= :minimumDateOfBirth AND f.id = :familyId")
    List<HouseholdDto> getChildrenByFamilyId(Date minimumDateOfBirth, int familyId);
}