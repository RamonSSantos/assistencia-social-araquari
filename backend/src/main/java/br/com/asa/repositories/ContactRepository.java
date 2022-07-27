package br.com.asa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.asa.models.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {}