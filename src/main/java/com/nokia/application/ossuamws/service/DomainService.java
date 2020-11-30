package com.nokia.application.ossuamws.service;

import java.util.List;

import com.nokia.application.ossuamws.model.Request.DomainRequest;
import com.nokia.application.ossuamws.model.entity.Domain;
import com.nokia.application.ossuamws.shared.Dto.DomainDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;

public interface DomainService {

	List<Domain> getAllDom();

	ResponseCode checkDompresent(String name);

	DomainDto createDom(DomainDto domDto);

	Domain checkDomainIsPresent(Integer domainId);

	DomainDto updateDomain(Domain domain, DomainRequest domReq);

	ResponseCode deleteDomain(Integer id);
		
	}