package com.nokia.application.ossuamws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nokia.application.ossuamws.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>,CrudRepository<Company, Integer>{

	@Query("select c from Company c where c.isActive=:status")
	List<Company> getActiveCompany(int status);


	Company findBycompanyName(String companyName);


	Company findBycompanyId(Integer companyId);

	@Transactional
	@Modifying
	@Query("update Company c set c.isActive =:status where c.companyId= :id")
	Integer softDelete(int status, Integer id);

}