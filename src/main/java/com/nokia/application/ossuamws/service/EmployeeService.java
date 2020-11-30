//package com.nokia.application.ossuamws.service;
//
//import java.io.IOException;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.nokia.application.ossuamws.model.Request.EmployeeRequest;
//import com.nokia.application.ossuamws.model.entity.Employee;
//import com.nokia.application.ossuamws.model.entity.EmployeeProfileInfo;
//import com.nokia.application.ossuamws.shared.Dto.EmployeeDto;
//import com.nokia.application.ossuamws.shared.businessException.RecordNotFoundException;
//import com.nokia.application.ossuamws.shared.utility.ResponseCode;
//
//public interface EmployeeService {
//
//	EmployeeDto saveEmpDetails(EmployeeDto empDto, MultipartFile file) throws IOException;
//
//	//Employee searchById(Integer id) throws RecordNotFoundException;
//
//	ResponseCode findByempId(String empId) throws RecordNotFoundException;
//
//	ResponseCode deleteEmp(Integer id);
//	
//	//Employee getByEmpId(String empId) throws RecordNotFoundException;
//
//	Object save(EmployeeRequest empReq);
//	
//	//Employee getFile(Integer id) throws RecordNotFoundException;
//
//	EmployeeProfileInfo searchByempId(Integer empId);
//
//}
