package com.nokia.application.ossuamws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nokia.application.ossuamws.model.entity.Nodes;

@Repository
public interface NodesRepository extends JpaRepository<Nodes, Integer>,CrudRepository<Nodes, Integer>{

	//Nodes findByNodeName(String nodeName);

}
