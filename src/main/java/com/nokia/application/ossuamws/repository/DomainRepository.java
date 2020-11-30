package com.nokia.application.ossuamws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nokia.application.ossuamws.model.entity.Domain;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer>,CrudRepository<Domain, Integer>{

	Domain findBydomainId(Integer domainId);

	Optional<Domain> findBydomainName(String name);

	@Transactional
	@Modifying
	@Query("update Domain d set d.isActive =:status where d.domainId= :id")
	Integer softDelete(int status, Integer id);


	
}
