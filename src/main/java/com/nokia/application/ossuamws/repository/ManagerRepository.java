package com.nokia.application.ossuamws.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nokia.application.ossuamws.model.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>,CrudRepository<Manager, Integer>{

	Manager findByname(String name);

	int deleteBymanagerId(long id);

	Optional<Manager> findBymanagerId(Integer id);

	@Transactional
	@Modifying
	@Query("update Manager m set m.isActive =:status ,m.deleteTimestamp=:deletedTs where m.managerId= :id")
	Integer softDelete(int status, LocalDateTime deletedTs, Integer id);

	@Query("select m from Manager m where m.isActive=:status")
	List<Manager> getActiveMgrs(int status);

	Manager findByManagerId(Integer id);
}
