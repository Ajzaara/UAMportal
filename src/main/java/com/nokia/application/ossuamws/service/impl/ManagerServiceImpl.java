package com.nokia.application.ossuamws.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.entity.Manager;
import com.nokia.application.ossuamws.repository.ManagerRepository;
import com.nokia.application.ossuamws.service.ManagerService;
import com.nokia.application.ossuamws.shared.Dto.ManagerDto;
import com.nokia.application.ossuamws.shared.businessException.RecordNotFoundException;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;
import com.nokia.application.ossuamws.shared.utility.Utils;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired	Utils utils;
	
	@Autowired	private	ManagerRepository managerRepository;

	@Override
	public List<Manager> getAllMgr() {
		return managerRepository.findAll();
	}


	@Override
	public Manager checkMgrIspresent(String name) throws RecordNotFoundException{
		Manager getMgrFromDB = managerRepository.findByname(name);
	       return getMgrFromDB;
	      
	}
	
	@Override
	public ResponseCode checkMgrpresent(String name){
		ResponseCode respCode=new ResponseCode();
			Manager getMgrFromDB = managerRepository.findByname(name);
			if (getMgrFromDB != null) {
				respCode.setResponseCode(1);
				respCode.setMessage("Manager exists");
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setObj(getMgrFromDB);
			} 
			else 
			{
				respCode.setResponseCode(0);
				respCode.setMessage("Manager doesn't exists");
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setObj(getMgrFromDB);
			}
			return respCode;
	}

	@Override
	public ManagerDto createMgr(ManagerDto mgrDto) {
		Manager mgrEntity=new Manager();
		mgrDto.setIsActive(1);
		BeanUtils.copyProperties(mgrDto, mgrEntity);
		
		Manager saveMgrDetails = managerRepository.save(mgrEntity);

		ManagerDto managerDto= new ManagerDto();
		BeanUtils.copyProperties(saveMgrDetails, managerDto);
		
		return managerDto;
		
	}

	@Override
	public ManagerDto updateMgr(Manager man,Manager mgrReq) {
		
		    ManagerDto managerDto =new ManagerDto();
		    
		    man.setMobile(mgrReq.getMobile());
		    man.setMailId(mgrReq.getMailId());
		    man.setName(mgrReq.getName());
		    man.setDomainId(mgrReq.getDomainId());
		    man.setModifyTimestamp(utils.getCurrentLocalDateTime());
		      
		    Manager updateMgrDetails=managerRepository.save(man);
		  
			BeanUtils.copyProperties(updateMgrDetails, managerDto);
			
			return managerDto;
	
	}
	

	@Override
	public Object deleteById(long id) {
		return managerRepository.deleteBymanagerId(id);
	}
	
	@Override
	public ResponseCode deleteMgr(Integer id) {
		
	ResponseCode respCode = new ResponseCode();
	Optional<Manager> getMgrIdFromDB = managerRepository.findBymanagerId(id);
	if (!getMgrIdFromDB.isPresent()) 
	{
		respCode.setResponseCode(0);
		respCode.setMessage("manager not found");
		respCode.setTimestamp(utils.getCurrentLocalDateTime());
		respCode.setAction("manager deletion failed");
	} else 
	{
		Integer status=getMgrIdFromDB.get().getIsActive();
		if(status==1) 
		{
			int s=0;
			LocalDateTime deletedTs=utils.getCurrentLocalDateTime();
			Integer delmgr= managerRepository.softDelete(s,deletedTs,id);
			
			if(delmgr!=0)
			{		
				respCode.setMessage("manager deleted successfully");
				respCode.setAction("manager deactivated  ");
				respCode.setResponseCode(1);
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setObj(getMgrIdFromDB);
			}
		}
		//int deleted=managerRepository.deleteBymanagerId(id);
		else
		{
			respCode.setResponseCode(0);
			respCode.setMessage("manager already inactive");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setAction("manager deletion failed ");
			respCode.setObj(getMgrIdFromDB);
		}
			
	}
	return respCode;
	
	}

	@Override
	public List<Manager> getAllActiveMgr() {
		int status=1;
		List<Manager> activeMgrs= managerRepository.getActiveMgrs(status);
		return activeMgrs;
	}


	@Override
	public Manager getMgrById(Integer id) {
		return managerRepository.findByManagerId(id);
	}


	@Override
	public Manager getMgrByName(String name) {
		return managerRepository.findByname(name);
	}

}
