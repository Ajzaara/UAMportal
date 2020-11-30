package com.nokia.application.ossuamws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nokia.application.ossuamws.model.Request.OperatorDetailsRequest;
import com.nokia.application.ossuamws.model.entity.Operator;
import com.nokia.application.ossuamws.model.entity.OperatorDetails;

@Repository
public interface OperatorDetailRepository extends JpaRepository<OperatorDetails, Integer>,CrudRepository<OperatorDetails, Integer>{


	OperatorDetails save(OperatorDetailsRequest empReq);

	
}
