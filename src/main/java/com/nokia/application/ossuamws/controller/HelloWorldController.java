package com.nokia.application.ossuamws.controller;

import java.util.logging.Logger;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.application.ossuamws.model.Request.OperatorDetailsRequest;
import com.nokia.application.ossuamws.model.entity.OperatorDetails;
import com.nokia.application.ossuamws.repository.DepartmentRepository;
import com.nokia.application.ossuamws.repository.DomainRepository;
import com.nokia.application.ossuamws.repository.NodesRepository;
import com.nokia.application.ossuamws.repository.OperatorDetailRepository;
import com.nokia.application.ossuamws.repository.UserRepository;
import com.nokia.application.ossuamws.service.SharedService;
import com.nokia.application.ossuamws.shared.utility.Utils;


@RestController
public class HelloWorldController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SharedService sharedService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DomainRepository domainRepository;
	
	@Autowired
	private NodesRepository nodesRepository;
	
	@Autowired
	private Utils utility;
	
	@Autowired	private OperatorDetailRepository operatorDetailRepository;

	private final static Logger LOGGER = Logger.getLogger(HelloWorldController.class.getName());
	
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}

	
	@PostMapping("/saveOperator")
	public ResponseEntity<OperatorDetails> createEmployee(@RequestBody OperatorDetailsRequest empReq)  {
		
		System.out.println("***********************"+empReq.toString());
		OperatorDetails empResDto = operatorDetailRepository.save(empReq);
		
			return ResponseEntity.status(HttpStatus.OK).body(empResDto);
		}

	}
	
	
	
	

