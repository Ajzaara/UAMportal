package com.nokia.application.ossuamws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nokia.application.ossuamws.model.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer>,CrudRepository<Vendor, Integer>{

	@Query("SELECT v FROM Vendor v WHERE v.operatorId = :opsId")
	List<Vendor> findVendorByoperatorId(Integer opsId);

	
}
