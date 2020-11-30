package com.nokia.application.ossuamws.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nokia.application.ossuamws.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>,CrudRepository<User, Integer>{

	Optional<User> findByUserName(String username);

	String findByfirstName(String firstName);

	String findBylastName(String lastName);

	Optional<User> findByuserId(Integer userId);


	@Transactional
	@Modifying
	@Query("update User u set u.isActive =:s ,u.deleteTimestamp=:deletedTs where u.userId= :id")
	Integer softDelete(@Param("s") int s,@Param("deletedTs") LocalDateTime deletedTs,@Param("id") Integer id);


	@Query("select u from User u where u.isActive=:status")
	List<User> getActiveUsers(int status);

}