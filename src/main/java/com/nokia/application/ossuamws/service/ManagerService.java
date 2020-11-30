package com.nokia.application.ossuamws.service;

import java.util.List;

import com.nokia.application.ossuamws.model.entity.Manager;
import com.nokia.application.ossuamws.shared.Dto.ManagerDto;
import com.nokia.application.ossuamws.shared.businessException.RecordNotFoundException;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;

public interface ManagerService {

	List<Manager> getAllMgr();

	ResponseCode checkMgrpresent(String name);

	ManagerDto createMgr(ManagerDto mgrDto);

	Object deleteById(long id);

	ResponseCode deleteMgr(Integer id);

	Manager checkMgrIspresent(String name) throws RecordNotFoundException;
	
	ManagerDto updateMgr(Manager man, Manager mgrReq);

	List<Manager> getAllActiveMgr();

	Manager getMgrById(Integer id);

	Manager getMgrByName(String name);

	}