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

import com.nokia.application.ossuamws.model.entity.DomainManager;
import com.nokia.application.ossuamws.model.entity.Manager;

@Repository
public interface DomainManagerRepository extends JpaRepository<DomainManager, Integer>,CrudRepository<DomainManager, Integer>{

	@Query("select m from DomainManager m where m.isActive=:status")
	List<DomainManager> getActiveDomMgrs(int status);

	DomainManager findBymailId(String mailId);

	Optional<DomainManager> findBydomainManagerId(Integer id);

	@Transactional
	@Modifying
	@Query("update DomainManager m set m.isActive =:status ,m.deleteTimestamp=:deletedTs where m.domainManagerId= :id")
	Integer softDelete(int status, LocalDateTime deletedTs, Integer id);

	@Query("SELECT d FROM DomainManager d WHERE d.managerId = :man")
	List<DomainManager> findBymanagerId(Optional<Manager> man);

	List<DomainManager> findAllBymanagerId(Integer id);

}
