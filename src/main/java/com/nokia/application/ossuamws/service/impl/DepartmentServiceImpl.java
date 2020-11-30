package com.nokia.application.ossuamws.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.Request.DepartmentRequest;
import com.nokia.application.ossuamws.model.entity.Department;
import com.nokia.application.ossuamws.repository.DepartmentRepository;
import com.nokia.application.ossuamws.service.DepartmentService;
import com.nokia.application.ossuamws.shared.Dto.DepartmentDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;
import com.nokia.application.ossuamws.shared.utility.Utils;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired Utils utils;
	
	@Override
	public List<Department> getAllDept() {
		return departmentRepository.findAll();
	}


	@Override
	public Department checkDeptIsPresent(Integer deptId) {
		Department getDeptFromDB = departmentRepository.findBydeptId(deptId);
	       return getDeptFromDB;
	}
	
	@Override
	public ResponseCode checkDeptpresent(String deptName) {
		ResponseCode respCode = new ResponseCode();
		Department getDepartmentFromDB = departmentRepository.findBydeptName(deptName);
		if (getDepartmentFromDB != null) {
			respCode.setResponseCode(1);
			respCode.setMessage("Department already exists");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
		} else {
			respCode.setResponseCode(0);
			respCode.setMessage("Department created");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
		}
		return respCode;
	}
	
	@Override
	public DepartmentDto createDept(DepartmentDto deptDto) {
		Department domEntity = new Department();
		DepartmentDto domResponse = new DepartmentDto();

		BeanUtils.copyProperties(deptDto, domEntity);
		
		domEntity.setIsActive(1);
		
		Department saveDeptDetails = departmentRepository.save(domEntity);

		BeanUtils.copyProperties(saveDeptDetails, domResponse);
		
		return domResponse;
	}

	@Override
	public DepartmentDto updatedept(Department dept, DepartmentRequest deptReq) {

		DepartmentDto deptDto =new DepartmentDto();
	    
	    dept.setDeptName(deptReq.getDeptName());
	      
	    Department updateMgrDetails=departmentRepository.save(dept);
	  
		BeanUtils.copyProperties(updateMgrDetails, deptDto);
		
		return deptDto;
	}


	@Override
	public ResponseCode deleteDept(Integer id) {
		
		ResponseCode respCode = new ResponseCode();
		Department getDeptIdFromDB = departmentRepository.findBydeptId(id);
		if (getDeptIdFromDB == null)
		{
			respCode.setResponseCode(0);
			respCode.setMessage("Department not found");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setAction("Department deletion failed");
		} else 
		{
			Integer status=getDeptIdFromDB.getIsActive();
			if(status==1) 
			{
				int s=0;
				Integer deldept= departmentRepository.softDelete(s,id);
				
				if(deldept!=0)
				{		
					respCode.setMessage("Department deleted successfully");
					respCode.setAction("Department deactivated  ");
					respCode.setResponseCode(1);
					respCode.setTimestamp(utils.getCurrentLocalDateTime());
					respCode.setObj(getDeptIdFromDB);
				}
			}
			//int deleted=managerRepository.deleteBymanagerId(id);
			else
			{
				respCode.setResponseCode(0);
				respCode.setMessage("Department already inactive");
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setAction("Department deletion failed ");
				respCode.setObj(getDeptIdFromDB);
			}
				
		}
		return respCode;
		
		}
	
	public void trueqw() {
		//StringUtils.
		//CollectionUtils
	}
	}


