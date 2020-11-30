package com.nokia.application.ossuamws.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.Request.CompanyRequest;
import com.nokia.application.ossuamws.model.entity.Company;
import com.nokia.application.ossuamws.repository.CompanyRepository;
import com.nokia.application.ossuamws.service.CompanyService;
import com.nokia.application.ossuamws.shared.Dto.CompanyDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;
import com.nokia.application.ossuamws.shared.utility.Utils;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired	Utils utils;
	@Autowired CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}

	@Override
	public List<Company> getAllActiveCompany() {
		int status=1;
		List<Company> activeCompany= companyRepository.getActiveCompany(status);
		return activeCompany;
	}

	@Override
	public ResponseCode checkCompanypresent(String companyName) {
		ResponseCode respCode = new ResponseCode();
		Company getCompanyFromDB = companyRepository.findBycompanyName(companyName);
		if (getCompanyFromDB != null) {
			respCode.setResponseCode(1);
			respCode.setMessage("Company already exists");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
		} else {
			respCode.setResponseCode(0);
			respCode.setMessage("Company created");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
		}
		return respCode;
	}

	@Override
	public CompanyDto createCompany(CompanyDto companyDto) {
		Company comEntity = new Company();
		CompanyDto companyResponse = new CompanyDto();

		BeanUtils.copyProperties(companyDto, comEntity);

		comEntity.setIsActive(1);

		Company saveCompanyDetails = companyRepository.save(comEntity);

		BeanUtils.copyProperties(saveCompanyDetails, companyResponse);

		return companyResponse;
	}

	@Override
	public Company checkCompIsPresent(Integer companyId) {
		Company getCompFromDB = companyRepository.findBycompanyId(companyId);
	       return getCompFromDB;
	}

	@Override
	public CompanyDto updateCompany(Company comp, CompanyRequest compReq) {
		CompanyDto compDto =new CompanyDto();
	    
		comp.setCompanyName(compReq.getCompanyName());
	      
	    Company updateCompDetails=companyRepository.save(comp);
	  
		BeanUtils.copyProperties(updateCompDetails, compDto);
		
		return compDto;
	}

	@Override
	public ResponseCode deleteComp(Integer id) {
		ResponseCode respCode = new ResponseCode();
		Company getCompIdFromDB = companyRepository.findBycompanyId(id);
		if (getCompIdFromDB == null)
		{
			respCode.setResponseCode(0);
			respCode.setMessage("Company not found");
			respCode.setTimestamp(utils.getCurrentLocalDateTime());
			respCode.setAction("Company deletion failed");
		} else 
		{
			Integer status=getCompIdFromDB.getIsActive();
			if(status==1) 
			{
				int s=0;
				Integer delcomp= companyRepository.softDelete(s,id);
				
				if(delcomp!=0)
				{		
					respCode.setMessage("Company deleted successfully");
					respCode.setAction("Company deactivated  ");
					respCode.setResponseCode(1);
					respCode.setTimestamp(utils.getCurrentLocalDateTime());
					respCode.setObj(getCompIdFromDB);
				}
			}
			else
			{
				respCode.setResponseCode(0);
				respCode.setMessage("Company already inactive");
				respCode.setTimestamp(utils.getCurrentLocalDateTime());
				respCode.setAction("Company deletion failed ");
				respCode.setObj(getCompIdFromDB);
			}
				
		}
		return respCode;
	}

	@Override
	public List<Company> getAllComp() {
		return companyRepository.findAll();
	}

}
