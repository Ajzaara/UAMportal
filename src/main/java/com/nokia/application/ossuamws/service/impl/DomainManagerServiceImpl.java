package com.nokia.application.ossuamws.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.Request.DomainManagerRequest;
import com.nokia.application.ossuamws.model.entity.DomainManager;
import com.nokia.application.ossuamws.model.entity.Manager;
import com.nokia.application.ossuamws.repository.DomainManagerRepository;
import com.nokia.application.ossuamws.repository.ManagerRepository;
import com.nokia.application.ossuamws.service.DomainManagerService;
import com.nokia.application.ossuamws.shared.Dto.DomainManagerDto;
import com.nokia.application.ossuamws.shared.Dto.ManagerDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;
import com.nokia.application.ossuamws.shared.utility.Utils;

@Service
public class DomainManagerServiceImpl implements DomainManagerService {

	@Autowired	Utils utils;
	@Autowired DomainManagerRepository domainManagerRepository;
	@Autowired ManagerRepository managerRepository;

	@Override
	public List<DomainManager> getAllDomMgr() {
		return domainManagerRepository.findAll();
	}
	
	@Override
	public List<DomainManager> getAllActiveDomMgr(){
		int status=1;
		List<DomainManager> activeDomMgrs= domainManagerRepository.getActiveDomMgrs(status);
		return activeDomMgrs;

	}

	@Override
	public ResponseCode checkDomMgrpresent(String mailId) {
		ResponseCode respCode=new ResponseCode();
		DomainManager getDomMgrFromDB =domainManagerRepository.findBymailId(mailId);
		if (getDomMgrFromDB != null) {
			respCode.setResponseCode(1);
			respCode.setMessage("DomainManager exists");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setObj(getDomMgrFromDB);
		} 
		else 
		{
			respCode.setResponseCode(0);
			respCode.setMessage("DomainManager doesn't exists");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setObj(getDomMgrFromDB);
		}
		return respCode;
		 
	}

	@Override
	public DomainManagerDto createDomMgr(DomainManagerDto domMgrDto) {
		DomainManager mgrEntity=new DomainManager();
		domMgrDto.setIsActive(1);
		BeanUtils.copyProperties(domMgrDto, mgrEntity);
		
		DomainManager saveMgrDetails = domainManagerRepository.save(mgrEntity);

		DomainManagerDto managerDto= new DomainManagerDto();
		BeanUtils.copyProperties(saveMgrDetails, managerDto);
		
		return managerDto;
		
	}

	@Override
	public DomainManager checkDomMgrIspresent(String mailId) {
		DomainManager getDomMgrFromDB = domainManagerRepository.findBymailId(mailId);
	       return getDomMgrFromDB;
	}

	@Override
	public DomainManagerDto updateDomMgr(DomainManager man, DomainManagerRequest domMgrReq) {
		DomainManagerDto managerDto =new DomainManagerDto();
	    
	    man.setMobile(domMgrReq.getMobile());
	    man.setMailId(domMgrReq.getMailId());
	    man.setName(domMgrReq.getName());
	    man.setDomainId(domMgrReq.getDomainId());
	    man.setManagerId(domMgrReq.getManagerId());
	    man.setModifyTimestamp(utils.getCurrentLocalDateTime());
	      
	    DomainManager updateMgrDetails=domainManagerRepository.save(man);
	  
		BeanUtils.copyProperties(updateMgrDetails, managerDto);
		
		return managerDto;
	}

	@Override
	public ResponseCode deleteDomMgr(Integer id) {
		ResponseCode respCode = new ResponseCode();
		Optional<DomainManager> getDomMgrIdFromDB = domainManagerRepository.findBydomainManagerId(id);
		if (!getDomMgrIdFromDB.isPresent()) {
			respCode.setResponseCode(0);
			respCode.setMessage("DomainManager not found");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setAction("DomainManager deletion failed");
		} 
		else 
		{
			Integer status = getDomMgrIdFromDB.get().getIsActive();
			if (status == 1) {
				int s = 0;
				LocalDateTime deletedTs = utils.getCurrentLocalDateTime();
				Integer delmgr = domainManagerRepository.softDelete(s, deletedTs, id);

				if (delmgr != 0) {
					respCode.setMessage("DomainManager deleted successfully");
					respCode.setAction("DomainManager deactivated  ");
					respCode.setResponseCode(1);
					respCode.setTimestamp(utils.getCurrentLocalDateTime());
					respCode.setObj(getDomMgrIdFromDB);
				}
			} 
			else 
			{
				respCode.setResponseCode(0);
				respCode.setMessage("DomainManager already inactive");
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setAction("DomainManager deletion failed ");
				respCode.setObj(getDomMgrIdFromDB);
			}

		}
		return respCode;
	}

	@Override
	public List<DomainManager> findDMbyManagerId(Integer id) {
		Optional<Manager> man=managerRepository.findBymanagerId(id);
		List<DomainManager> dm=domainManagerRepository.findBymanagerId(man);
		return dm;
	}

}
