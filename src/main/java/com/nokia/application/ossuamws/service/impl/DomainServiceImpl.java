package com.nokia.application.ossuamws.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.Request.DomainRequest;
import com.nokia.application.ossuamws.model.entity.Department;
import com.nokia.application.ossuamws.model.entity.Domain;
import com.nokia.application.ossuamws.repository.DomainRepository;
import com.nokia.application.ossuamws.service.DomainService;
import com.nokia.application.ossuamws.shared.Dto.DomainDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;
import com.nokia.application.ossuamws.shared.utility.Utils;

@Service
public class DomainServiceImpl implements DomainService {

	@Autowired private DomainRepository domainRepository;
	
	@Autowired Utils utils;
	
	@Override
	public List<Domain> getAllDom() {
		return domainRepository.findAll();
	}

	@Override
	public ResponseCode checkDompresent(String name) {
		ResponseCode respCode = new ResponseCode();

		Optional<Domain> getDomainFromDB = domainRepository.findBydomainName(name);
		if (getDomainFromDB.isPresent()) {
			respCode.setResponseCode(1);
			respCode.setMessage("Domain already exists");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
		} else {
			respCode.setResponseCode(0);
			respCode.setMessage("Domain created");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
		}
		return respCode;
	}

	@Override
	public DomainDto createDom(DomainDto domDto) {
		Domain domEntity = new Domain();
		DomainDto domResponse = new DomainDto();

		BeanUtils.copyProperties(domDto, domEntity);
		domEntity.setIsActive(1);

		Domain saveDomDetails = domainRepository.save(domEntity);

		BeanUtils.copyProperties(saveDomDetails, domResponse);
		
		return domResponse;

	}

	@Override
	public Domain checkDomainIsPresent(Integer domainId) {
		return domainRepository.findBydomainId(domainId);
	}

	@Override
	public DomainDto updateDomain(Domain domain, DomainRequest domReq) {
		DomainDto domainDto =new DomainDto();
	    
		domain.setDomainName(domReq.getDomainName());
	      
	    Domain updateDomainDetails=domainRepository.save(domain);
	  
		BeanUtils.copyProperties(updateDomainDetails, domainDto);
		
		return domainDto;
	}

	@Override
	public ResponseCode deleteDomain(Integer id) {
		ResponseCode respCode = new ResponseCode();
		Domain getDomainIdFromDB = domainRepository.findBydomainId(id);
		if (getDomainIdFromDB == null)
		{
			respCode.setResponseCode(0);
			respCode.setMessage("Domain not found");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setAction("Domain deletion failed");
		} else 
		{
			Integer status=getDomainIdFromDB.getIsActive();
			if(status==1) 
			{
				int s=0;
				Integer deldept= domainRepository.softDelete(s,id);
				
				if(deldept!=0)
				{		
					respCode.setMessage("Domain deleted successfully");
					respCode.setAction("Domain deactivated  ");
					respCode.setResponseCode(1);
					respCode.setTimestamp(utils.getCurrentLocalDateTime());
					respCode.setObj(getDomainIdFromDB);
				}
			}
			else
			{
				respCode.setResponseCode(0);
				respCode.setMessage("Domain already inactive");
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setAction("Domain deletion failed ");
				respCode.setObj(getDomainIdFromDB);
			}
				
		}
		return respCode;
	}
}
