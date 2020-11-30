package com.nokia.application.ossuamws.service;

import java.util.List;

import com.nokia.application.ossuamws.model.Request.DomainManagerRequest;
import com.nokia.application.ossuamws.model.entity.DomainManager;
import com.nokia.application.ossuamws.shared.Dto.DomainManagerDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;

public interface DomainManagerService {

	List<DomainManager> getAllDomMgr();

	List<DomainManager> getAllActiveDomMgr();

	ResponseCode checkDomMgrpresent(String mailId);

	DomainManagerDto createDomMgr(DomainManagerDto domMgrDto);

	DomainManager checkDomMgrIspresent(String mailId);

	DomainManagerDto updateDomMgr(DomainManager man, DomainManagerRequest domMgrReq);

	ResponseCode deleteDomMgr(Integer id);

	List<DomainManager> findDMbyManagerId(Integer id);

	}