package com.nokia.application.ossuamws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nokia.application.ossuamws.model.entity.Circles;

@Repository
public interface CirclesRepository extends JpaRepository<Circles, Integer>,CrudRepository<Circles, Integer>{

	List<Circles> findByvendorId(Integer id);

	Circles findBycircleId(Integer circleId);


	
}
