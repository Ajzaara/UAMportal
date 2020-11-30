package com.nokia.application.ossuamws.service;

import java.util.List;

import com.nokia.application.ossuamws.model.Request.DepartmentRequest;
import com.nokia.application.ossuamws.model.entity.Department;
import com.nokia.application.ossuamws.shared.Dto.DepartmentDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;

public interface DepartmentService {

	List<Department> getAllDept();

	DepartmentDto createDept(DepartmentDto deptDto);

	ResponseCode checkDeptpresent(String deptName);

	DepartmentDto updatedept(Department dept, DepartmentRequest deptReq);

	Department checkDeptIsPresent(Integer deptId);

	ResponseCode deleteDept(Integer id);
		
	}