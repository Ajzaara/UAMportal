package com.nokia.application.ossuamws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nokia.application.ossuamws.model.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>,CrudRepository<Department, Integer>{

	Department findBydeptName(String deptName);

	Department findBydeptId(Integer deptId);
	
	
	@Transactional
	@Modifying
	@Query("update Department d set d.isActive =:status where d.deptId= :id")
	Integer softDelete(int status, Integer id);


	
}
