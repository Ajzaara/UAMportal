package com.nokia.application.ossuamws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nokia.application.ossuamws.model.entity.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer>,CrudRepository<Operator, Integer>{

	
}
