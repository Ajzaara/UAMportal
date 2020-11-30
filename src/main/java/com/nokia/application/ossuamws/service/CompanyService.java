package com.nokia.application.ossuamws.service;

import java.util.List;

import com.nokia.application.ossuamws.model.Request.CompanyRequest;
import com.nokia.application.ossuamws.model.entity.Company;
import com.nokia.application.ossuamws.shared.Dto.CompanyDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;

public interface CompanyService {

	List<Company> getAllCompany();

	List<Company> getAllActiveCompany();

	ResponseCode checkCompanypresent(String companyName);

	CompanyDto createCompany(CompanyDto companyDto);

	Company checkCompIsPresent(Integer companyId);

	CompanyDto updateCompany(Company comp, CompanyRequest compReq);

	ResponseCode deleteComp(Integer id);

	List<Company> getAllComp();

		
		
	}