package br.com.asa.repositories;

import br.com.asa.models.SubdepartmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubdepartmentRepository extends PagingAndSortingRepository<SubdepartmentEntity, Integer> {
    @Query("SELECT s FROM SubdepartmentEntity s WHERE s.description LIKE :search%")
    List<SubdepartmentEntity> getBySubdepartment(String search);
}