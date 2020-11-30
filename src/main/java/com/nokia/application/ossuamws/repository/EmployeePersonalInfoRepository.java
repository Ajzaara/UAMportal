package com.nokia.application.ossuamws.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nokia.application.ossuamws.model.Request.EmployeeRequest;
import com.nokia.application.ossuamws.model.entity.EmployeePersonalInfo;

@Repository
public interface EmployeePersonalInfoRepository extends JpaRepository<EmployeePersonalInfo, Integer>,CrudRepository<EmployeePersonalInfo, Integer>{

	Optional<EmployeePersonalInfo> findByempId(String empId);

	
	Optional<EmployeePersonalInfo> findById(Integer id);

	Object save(EmployeeRequest empReq);

	@Transactional
	@Modifying
	@Query("update EmployeePersonalInfo e set e.isActive =:s ,e.deleteTimestamp=:deletedTs where e.Id= :id")
	Integer softDelete(@Param("s") int s,@Param("deletedTs") LocalDateTime deletedTs,@Param("id") Integer id);

}
